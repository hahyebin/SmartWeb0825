package com.koreait.ex07.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex07.command.BoardDeleteCommand;
import com.koreait.ex07.command.BoardInsertCommand;
import com.koreait.ex07.command.BoardListCommand;
import com.koreait.ex07.command.BoardUpdateCommand;
import com.koreait.ex07.command.BoardViewCommand;
import com.koreait.ex07.dto.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	
		private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
//		private BoardListCommand boardListCommand;
//		private BoardInsertCommand boardInsertCommand;	
//		private BoardViewCommand boardViewCommand;
//		private BoardUpdateCommand boardUpdateCommand;
//		private BoardDeleteCommand boardDeleteCommand;
//		
//		public BoardController(BoardListCommand boardListCommand, BoardInsertCommand boardInsertCommand,
//				BoardViewCommand boardViewCommand, BoardUpdateCommand boardUpdateCommand,
//				BoardDeleteCommand boardDeleteCommand) {
//			super();
//			this.boardListCommand = boardListCommand;
//			this.boardInsertCommand = boardInsertCommand;
//			this.boardViewCommand = boardViewCommand;
//			this.boardUpdateCommand = boardUpdateCommand;
//			this.boardDeleteCommand = boardDeleteCommand;
//		}


		@Autowired  // root-context 의 bean 과 일치하게 만들어야 bean 사용이 가능하다.
		private BoardListCommand boardListCommand;
		
		@Autowired  // root-context 의 bean 과 일치하게 만들어야 bean 사용이 가능하다.
		private BoardInsertCommand boardInsertCommand;
		
		@Autowired  // root-context 의 bean 과 일치하게 만들어야 bean 사용이 가능하다.
		private BoardViewCommand boardViewCommand;
		
		@Autowired
		private BoardUpdateCommand boardUpdateCommand;
		
		@Autowired
		private BoardDeleteCommand boardDeleteCommand;
		
		
		// 목록확인 매핑
		@GetMapping("selectBoardList.do")
		public String selectBoardList(Model model) {
			boardListCommand.execute(model);   // 이곳에 가서 리스트 로그 찍음 
			return "board/list";
		}
		
		
		
		
		
		
		// 등록하러 가는 매핑
		@GetMapping("insertBoardForm.do")
		public String insertBoardForm() {
			return "board/insert";
		}
		
		
		
		
		
		// 등록 db저장은 boardinsertcommand에서 함 리턴은 그곳에서 함
		@PostMapping("insertBoard.do")                                                // model은 command의 형태를 통일시켜주기 위함이다.
		public void insertBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
			// BoardInsertCommand는 model만 받을 수 있다.
			// Model에 request와 response 저장
			  model.addAttribute("request", request);
			  model.addAttribute("response", response);
			// BoardInsertCommand는 받은 Model에서 request, resposne 를 꺼내서 사용 함 
			  boardInsertCommand.execute(model);  // 현재 이 모델은 jsp에 반환하기 위한 model이 아니라 command에 request, response를 담아서 전달하기 위한 목적이다
		}
		
		
//		@GetMapping("selectBoardByNo.do")
//		public String selectBoardByNo(@RequestParam(value="no", defaultValue="0", required=false) Long no, Model model) {
//			
//		}
		
		@GetMapping("selectBoardByNo.do")
		public String selectBoardByNo(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			boardViewCommand.execute(model);
			return "board/detail";
			
		}
		
		// 수정하러가기
		@GetMapping(value="updateBoardForm.do")
		public String updateBoardForm(@ModelAttribute("board") Board board) {
			return "board/update";
		}
		
		@PostMapping(value="updateBoard.do")
		public void updateBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
			model.addAttribute("request", request);
			model.addAttribute("response", response);
			boardUpdateCommand.execute(model);
		}
		
		@GetMapping(value="deleteBoard.do")
		public void deleteBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
			model.addAttribute("request", request);
			model.addAttribute("response", response);
			boardDeleteCommand.execute(model);
		}
}
