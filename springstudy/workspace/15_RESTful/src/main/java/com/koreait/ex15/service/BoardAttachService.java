package com.koreait.ex15.service;

import org.springframework.stereotype.Service;

import com.koreait.ex15.domain.BoardAttach;

@Service
public interface BoardAttachService {
	
	// 게시글 등록
	public int addBoardAttach(BoardAttach boardAttach);
}
