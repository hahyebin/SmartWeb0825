package service.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.jdbc.BoardDAO;
import dto.Board;

public class BoardInsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	try {
			// $('#f').serialize()로 받은 파라미터들
			String bNo = request.getParameter("bNo");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// DB로 보낼 bean
			Board board = new Board();
			board.setbNo(bNo);
			board.setWriter(writer);
			board.setContent(content);
			
			// DB에 삽입 
			int result = BoardDAO.getInstance().insertBoard(board);
			// -> jdbc dao 활용시 jdbc dao에서 캐치를 해결하기 때문에 예외가 발생하지 않는다. 
			// package dao.jdbc BoardDao 82번 삽입 쿼리에서 catch를 작성하지 않고, 예외를 던져서 이곳에서 받도록한다 
			// 즉 error 프로퍼티가 전달 될 수 있도록 한다. 
			
			
			// 성공 실패 여부를 JSON 데이터로 작성 
			// {"result" : true  } 또는 { "result" : false }
			JSONObject obj = new JSONObject();
			obj.put("result", result > 0 );   // 성공하면 트루, 실패하면  false로 보내는
			
			// JSON 데이터의 반환 
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.close();
	}
	
	// catch 블록의 response는 ajax의 error응답을 보냄 
	
	// 예외코드 정리 
	// 2001 : 동일한 게시글 번호 재등록, 필수 칼럼 누락
	// 2002 : 잘못된 데이터 전달(DB 오류)
	// 2003 : 알 수 없는 예외
	
	catch(SQLIntegrityConstraintViolationException e) {   
		
		// 텍스트의 타입 : text/plain
		response.setContentType("text/plain charset=UTF-8");
		
		// 에러 메시지 전달
		PrintWriter out = response.getWriter();   // response 타입이 다르므로 각각 지정하기
		out.println("동일한 게시글 번호가 있거나 필수 정보가 누락되었습니다.");
		
		// 에러 코드 전달
		response.setStatus(2001);   // 에러 코드 2001 발생 (2001은 마음대로 정한 값 )		
     	
	} catch(SQLException e) {
		// 	e.printStackTrace();  -> 어떤 에러인지 확인가능
		response.setContentType("text/plain charset=UTF-8");
		
		// 에러 메시지 전달
		PrintWriter out = response.getWriter();  
		out.println("잘못된 데이터 전달");
		
		// 에러 코드 전달
		response.setStatus(2002);   // 에러 코드 2002 발생 (2002은 마음대로 정한 값 )		
		
	} catch(Exception e) {
		
		response.setContentType("text/plain charset=UTF-8");
		
		// 에러 메시지 전달
		PrintWriter out = response.getWriter();  
		out.println("알수없는 예외가 발생했습니다.");
		
		// 에러 코드 전달
		response.setStatus(2003);
	}
	
	
	
	
	
	}
}
