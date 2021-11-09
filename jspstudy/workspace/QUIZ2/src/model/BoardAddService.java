package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardAddService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO(title, writer, content);    // writer title content 매개변수 생성자 만들었으므로 가능 
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setWriter(writer);
//		boardDTO.setTitle(title);
//		boardDTO.setContent(content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.insert(boardDTO);    // return 0 or 1
		
		PrintWriter out  = null;
			try {
				out = response.getWriter();
				if ( result > 0 ) {						// DB 삽입 수정 삭제는 redirect				
					out.println("<script>");
					out.println("alert('삽입 성공.');");
					out.println("location.href='/QUIZ2/selectList.board';");  // 전체 리스트로 -> redirect 
					out.println("</script>");
					out.close();
				} else {
					out.println("<script>");
					out.println("alert('삽입 실패.');");
					out.println("history.back();");
					out.println("</script>");
					out.close();
				}
			} catch (IOException e) {		e.printStackTrace();	}
			
			return null;
		
	}

}
