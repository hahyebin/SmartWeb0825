package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdate implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    
		Long idx = Long.parseLong(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content"); 
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setIdx(idx);
		boardDTO.setTitle(title);
		boardDTO.setContent(content);
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.update(boardDTO);
		
		
		PrintWriter out  = null;
  

			out = response.getWriter();
			if ( result > 0 ) {		// DB 삽입 수정 삭제는 redirect				
				out.println("<script>");
				out.println("alert('수정 성공');");
				out.println("history.back();");  // 전체 리스트로 돌아가자 redirect 
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('수정 실패');");
				out.println("history.back();");  // 전체 리스트로 돌아가자 redirect 
				out.println("</script>");
			}
		
		return null;
	}

}
