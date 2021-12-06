package com.koreait.ex06.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.repository.BoardRepository;

public class BoardServiceImpl implements BoardService{
	
	// field 
	@Autowired   // Autowired 을 사용하면 configuration을 찾아서 타입을 일치하는 걸 가져온다. -> configuration은  BoardConfig클래스에서 지정함
	private BoardRepository repository;
	
	@Override
	public List<Board> selectBoardList() {
		return repository.selectBoardList();
	}
	
	@Override
	public void insertBoard(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		int result = repository.insertBoard(board);
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			if(result > 0 ) {
				out.println("<script>");
				out.println("alert('게시글 등록 성공')");
				out.println("location.href='/ex06/board/selectBoardList.do'");  // location 이동은 redirect
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
	
	
	
	
	// 게시글 상세보기
	@Override
	public Board selectBoardByNo(Long no) {
		return repository.selectBoardByNo(no);
	}
	
	
	
	
	// 게시글 수정
	@Override
	public void updateBoard(Board board, HttpServletResponse response) {
		
		int result = repository.updateBoard(board);
		
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			if(result > 0 ) {
				out.println("<script>");
				out.println("alert('게시글 수정 성공')");
				out.println("location.href='/ex06/board/selectBoardByNo.do?no="+board.getNo()+"'");   // redirect 처리로 다시 번호 갖고 상세보고 페이지로 이동 
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
	
	
	
	
	// 게시글삭제
	@Override
	public void deleteBoard(Long no, HttpServletResponse response) {
	
		int result = repository.deleteBoard(no);
		
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			if(result > 0 ) {
				out.println("<script>");
				out.println("alert('게시글 삭제 성공')");
				out.println("location.href='/ex06/board/selectBoardList.do'");  // location 이동은 redirect
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글 삭제 실패')");
				out.println("history.back()");  // location 이동은 redirect
				out.println("</script>");
			}
		} catch(Exception e) {
			e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                   
		}
		
	}
	
	
	
} // end of class
