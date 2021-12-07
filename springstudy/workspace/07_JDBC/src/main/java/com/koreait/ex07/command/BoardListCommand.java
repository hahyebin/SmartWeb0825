package com.koreait.ex07.command;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.controller.BoardController;
import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

// BoardListCommand bean을 만들때 boardDAO bean을 만들려고 한다,(프로젝트 순서상 boardDao다음에 listCommand가 만들어져야함 )
// 그래서 root-context에  빈을 모두 만들면 이후 것들이 순서상 만들어지지 않아 오류가 난다.
// 때문에 boardDao먼저 root에 빈을 만들고 이후 모든 것들을 servlet-context에 만들게 한다.
// 빈을 만드는 순서는 root-context ---> servlet-context이다.
public class BoardListCommand {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// root-context의  클래스와 아이디랑 똑같이 쓰기
	@Autowired
	private BoardDAO boardDAO;
	
	
	public void execute(Model model) {
		List<Board> list = boardDAO.selectBoardList();
		logger.info(list.toString());
		model.addAttribute("list", list);
		
	}
}
