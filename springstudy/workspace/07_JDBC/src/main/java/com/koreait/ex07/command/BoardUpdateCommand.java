package com.koreait.ex07.command;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

public class BoardUpdateCommand {
	// root-context의  클래스와 아이디랑 똑같이 쓰기
		@Autowired
		private BoardDAO boardDAO;
		
		public void execute(Model model) {
			
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			HttpServletResponse response = (HttpServletResponse)map.get("response");
			
		 Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		 Long no = Long.parseLong(opt.orElse("0"));
			
			Board board = new Board();
			board.setNo(no);
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			
			  
			  
			  
			int result = boardDAO.updateBoard(board);
			
			try {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				if(result > 0 ) {
					out.println("<script>");
					out.println("alert('게시글 수정 성공')");
					out.println("location.href='/ex07/board/selectBoardByNo.do?no="+board.getNo()+"'");  // location 이동은 redirect
					out.println("</script>");
				} else {
					out.println("<script>");
					out.println("alert('게시글 수정 실패')");
					out.println("history.back()");  // location 이동은 redirect
					out.println("</script>");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
}
