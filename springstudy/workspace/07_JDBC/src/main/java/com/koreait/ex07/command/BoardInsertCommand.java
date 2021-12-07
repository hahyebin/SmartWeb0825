package com.koreait.ex07.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.controller.BoardController;
import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

public class BoardInsertCommand {
	
	
	// root-context의  클래스와 아이디랑 똑같이 쓰기
	@Autowired
	private BoardDAO boardDAO;
	
	
	public void execute(Model model) {

		//model에서 request, response 꺼내기
		// model을 Map으로 변경하고 get() 메소드로 꺼낸다.
		// model을 map으로 바꾸는 메소드를 이용해서 꺼내서 쓴다. 
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		int result = boardDAO.insertBoard(board);
		
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			if(result > 0 ) {
				out.println("<script>");
				out.println("alert('게시글 등록 성공')");
				out.println("location.href='/ex07/board/selectBoardList.do'");  // location 이동은 redirect
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글 등록 실패')");
				out.println("history.back()");  // location 이동은 redirect
				out.println("</script>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
