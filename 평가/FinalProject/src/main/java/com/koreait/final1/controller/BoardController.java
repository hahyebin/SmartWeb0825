package com.koreait.final1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.final1.domain.Board;
import com.koreait.final1.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
    // 첫화면
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
    // 리스트
	@GetMapping(value="/board/list")
	public String list(Model model) {
		model.addAttribute("list", boardService.getBoards());
		model.addAttribute("boardCount", boardService.getBoardCount());
		return "board/list" ;
	}
	
    // 등록하러 가기만
	@GetMapping(value="/board/addForm")
	public String addForm() {
		return "board/insert";
	}
    // 실제 등록
	@PostMapping(value="/board/add")
	public void add(Board board, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(board);
		int result = boardService.addBoard(board);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.append("<script>");
				out.append("alert('삽입 성공');");
				out.append("location.href='" + request.getContextPath() + "/board/list';");
				out.append("</script>");
				out.close();
			} else {
				out.append("<script>");
				out.append("alert('삽입 실패');");
				out.append("history.back();");
				out.append("</script>");
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value="/board/detail")
	public String detail(Long idx, Model model) {
		System.out.println("상세보기 번호 : " +idx);
		model.addAttribute("board", boardService.getBoard(idx));
		return "board/detail";
	}

	@GetMapping(value="/board/modify")
	public void modify(Board board, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("수정 board : " + board);
		
		int result = boardService.modifyBoard(board);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.append("<script>");
				out.append("alert('수정 성공');");
				out.append("location.href='" + request.getContextPath() + "/board/list';");
				out.append("</script>");
				out.close();
			} else {
				out.append("<script>");
				out.append("alert('수정 실패');");
				out.append("history.back();");
				out.append("</script>");
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value="/board/remove")
	public void remove(Board board, HttpServletRequest request, HttpServletResponse response) {
	  System.out.println("삭제 idx : " + board.getbIdx());
	 
		
		int result = boardService.removeBoard(board.getbIdx());
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.append("<script>");
				out.append("alert('삭제 성공');");
				out.append("location.href='" + request.getContextPath() + "/board/list';");
				out.append("</script>");
				out.close();
			} else {
				out.append("<script>");
				out.append("alert('삭제 실패');");
				out.append("history.back();");
				out.append("</script>");
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
