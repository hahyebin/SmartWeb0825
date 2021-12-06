package com.koreait.ex06.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	   // 로그 생성기 
	   // System.out.println() 대체 도구 
		private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
		// BoardSerivce Interface
		@Autowired
		private BoardService service;
		
		@GetMapping("selectBoardList.do")
		public String selectBoardList(Model model) {  		 // model : jsp로 값 넘김
//			logger.info("selectBoardList() 호출 ");    		 // console에 정보가 찍힌다.
	   
        // BoardService는 인터페이스기 때문에 인터페이스를 구현한 BoardServiceImpl이 객체를 생성할 수 있다.
		//	service = new BoardServiceImpl();					
			   // --> new 로 생성하려했지만 new 가 마지막에 실행되면서 BoardServiceImpl에서 BoardRepository가 생성이 되지 않아 Autowired가 찾지 못하게 되어서 오류가 난다.
			  // -> 해결 : serviece 를 Autowired해서 Bean을 생성하자(코드26)
			List<Board> list = service.selectBoardList();
			logger.info(list.toString());  // board 목록을 console에서 확인할 수 있다.
			
			model.addAttribute("list", list);   // 내부적으로 request.setAttribute("list", list)임   model에 board/list.jsp 로 갈 list로 저장	
			// model은 redirect로 가도 저장가능하다
			return "board/list";  // board/list.jsp로 forward함(model에 저장한 list가 전달됨)
		}
		
		@GetMapping("insertBoardForm.do")
		public String insertBoardForm() {
			return "board/insert";
		}
		
		
		// 방법1. HttpServletRequest request에 파라미터 받고 저장해서 넘기기
		@PostMapping("insertBoard.do")
		public void insertBoard(HttpServletRequest request, HttpServletResponse response) {
			service.insertBoard(request, response);    //  --> 이곳에서 이동을 모두 처리하기 때문에 controller에서는 아무런 이동이 없다.
			logger.info("insertBoard()");
			// 삽입 후 리스트 컨트롤러로 redirect로 가야지 정상작동한다!!!! .do 로 가기(jsp도, forward도 아니다!!)
			// return "redirect:selectBoardList.do";      
		}
		
		
		// 방법2. @RequestParam에 파라미터 받고 저장해서 넘기기
		@GetMapping("selectBoardByNo.do")
		public String selectBoardByNo(@RequestParam Long no, Model model) {   // @RequestParam(value="no") Long no
			
			model.addAttribute("board", service.selectBoardByNo(no));
			return "board/detail";
			
		}
		
		
		
	  //  수정하러 가는 길
		@GetMapping("updateBoardForm.do")
		public String updateBoardForm(@ModelAttribute(value="board") Board board) {    
			// detail.jsp에서 보낸 파라미터 3개는 Board board 가 받고,
			// model에 "board" 속성으로 저장함 : model.addAttribute("board",board)
			return "board/update";
		}
		
		
	  // 방법3. Board에 파라미터 받고 저장해서 넘기기  -> 스프링이 받아서 저장해줌
	  // ct의 수정 요청에서 받는 컨트롤러
		@PostMapping("updateBoard.do")
		public void updateBoard(Board board, HttpServletResponse response) {
			service.updateBoard(board, response);    //  --> 이곳에서 이동을 모두 처리하기 때문에 controller에서는 아무런 이동이 없다.
			logger.info("updateBoard()");
			// 삽입 후 리스트 컨트롤러로 redirect로 가야지 정상작동한다!!!! .do 로 가기(jsp도, forward도 아니다!!)
		
		}
		
		// ct의 삭제 요청에서 받는 컨트롤러
		@GetMapping("deleteBoard.do")
		public void deleteBoard(@RequestParam(value="no", required=false, defaultValue="0") Long no,    // no은 필수 조건이 아니며 만약 번호전달이 없으면 0으로 전달된다. 0은 없기 때문에 삭제 실패가 뜬다.
											HttpServletResponse response) {   
			service.deleteBoard(no, response);    //  --> 이곳에서 이동을 모두 처리하기 때문에 controller에서는 아무런 이동이 없다.  
												  // ==> 처리는 service에서! (BoardSerivce 인터페이스가 있고, 각 메서드를 구현하는 BoardServiceImpl구현체를 따로 만듦,  직접 쿼리만드는 구현체임)  ++ 만약 데이터를 다른 방법으로 갖고 오고싶으면 구현체만 바꾸면 됨 
			logger.info("deleteBoard()");
			// 삽입 후 리스트 컨트롤러로 redirect로 가야지 정상작동한다!!!! .do 로 가기(jsp도, forward도 아니다!!)
			
		}
		
		
		
} // end of class
