package com.koreait.ex15.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.Board;

@Repository
public interface BoardRepository {
	
   // 이미지 게시글 등록
  public int insertBoard(Board board);
}
