package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import dao.MemberDAO;
import dto.Member;

// 0~100 체크 예외 생성
class NumberLengthException extends Exception {
	NumberLengthException (String msg) { 
        super(msg); 
    }
}
// 중복 예외
class NoCheckException extends Exception {
	NoCheckException (String msg) { 
        super(msg); 
    }
}

public class InsertMemberCommand implements MemberService{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

	try {
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		if(age<0  || age>100) {
			throw new NumberLengthException("나이는 0~100 사이만 입력 가능합니다.");
		}
		String birthday = request.getParameter("birthday");
	   
		// 중복 확인 
		boolean noCheck = MemberDAO.getInstance().noCheck(no);
		if(noCheck == false) {
			throw new NoCheckException("동일한 회원번호는 입력할 수 없습니다.");
		}
		
		
		Member member = new Member();
		member.setNo(no);
		member.setName(name);
		member.setAge(age);
		member.setBirthday(birthday);
	
		int result = MemberDAO.getInstance().insertMember(member);
		
	
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
	}
	// 번호중복
	catch(NoCheckException e) {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		response.setStatus(5555);
		out.println(e.getMessage());
	}
	// 나이 범위
	catch(NumberLengthException e) {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		response.setStatus(3333);
		out.println(e.getMessage());
	}
	// 숫자아님
	catch(NumberFormatException e) {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("나이는 정수만 가능합니다.");

		response.setStatus(2222);
	}
	// 데이터 오류
	catch(PersistenceException e) {      
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.println("데이터 입력을 확인해주세요");
		response.setStatus(1111);
		

	}
	
 }


} // class
