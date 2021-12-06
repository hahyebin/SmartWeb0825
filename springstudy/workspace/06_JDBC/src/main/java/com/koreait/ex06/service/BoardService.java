package com.koreait.ex06.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.ex06.domain.Board;

public interface BoardService {
	
	public List<Board> selectBoardList();												// 게시글 목록보기
	public void insertBoard(HttpServletRequest request, HttpServletResponse response);  // 게시글 삽입
	public Board selectBoardByNo(Long no); 												// 게시글 상세보기
	
	public void updateBoard(Board board, HttpServletResponse response); 				 // 게시글 수정
	public void deleteBoard(Long no, HttpServletResponse response);  					 // 게시글 삭제
	
}
