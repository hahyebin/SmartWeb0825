package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO mem = new MemberDTO();
		mem.setName(name);
		mem.setId(id);
		
		int result = MemberDAO.getInstance().insert(mem);
		
		PrintWriter out = response.getWriter();
		if( result > 0 ) {
			out.println("<h1>가입되었습니다.</h1>");
			out.println("<a href='/ServerProgram/loginPage.do?id='"+id+"&name="+name+">로그인</a>");
			out.close();
		} 
		// 가입 추ㅣ소 없음
		

		return null;
	}

}
