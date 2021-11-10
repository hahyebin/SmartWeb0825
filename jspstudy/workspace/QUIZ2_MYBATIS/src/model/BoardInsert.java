package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardInsert implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO boardDto = new BoardDTO(title, writer, content); 
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.insert(boardDto);
		
		PrintWriter out = response.getWriter();
	
		if(result > 0 ) {
			out.println("<script>");
			out.println("alert('삽입 성공.');");
			out.println("location.href='/Q_MYBATIS/boardAllList.do' ");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삽입 실패.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
