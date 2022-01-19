package com.koreait.final1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.final1.domain.Board;
import com.koreait.final1.repository.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<Board> getBoards() {
		return boardMapper.selectList();
	}

	@Override
	public Long getBoardCount() {
		return boardMapper.selectBoardCount();
	}
   
	// 상세보기
	@Override
	public Board getBoard(Long idx) {
		return  boardMapper.selectByIdx(idx);
	}

	@Override
	public int addBoard(Board board) {
		int result = boardMapper.insertBoard(board);
		return result;
	}

	@Override
	public int modifyBoard(Board board) {
		int result = boardMapper.updateBoard(board);
		return result;
	}

	@Override
	public int removeBoard(Long idx) {
		int result = boardMapper.deleteBoard(idx);
		return result;
	}

}
