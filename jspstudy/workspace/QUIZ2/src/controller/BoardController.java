package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardAddService;
import model.BoardListService;
import model.BoardModifyService;
import model.BoardRemoveService;
import model.BoardSeleteService;
import model.BoardService;

// controller  .board로 통일하기
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardController() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length-1];
		
		ModelAndView modelAndView = null;
		BoardService boardService = null;  //인터페이스 구현한 자손들 실행할 것 
		
		switch(command) {
		case "insert.board":                               // 삽입
			boardService = new BoardAddService();
			break;
		case "modify.board":                               // 수정 
			boardService = new BoardModifyService();
			break;
		case "delete.board":                               // 삭제
			boardService = new BoardRemoveService();
			break;
		case "seleteDTO.board":                            // 상세조회
			boardService = new BoardSeleteService();
			break;
		case "selectList.board":                           // 전체조회
			boardService = new BoardListService();
			break; 
		case "insertForm.board":						  // 새글 작성
			modelAndView = new ModelAndView("views/BoardWrite.jsp",false);
			break;
		}
		
		if( boardService != null ) {
			modelAndView = boardService.execute(request, response);  
		}
		
		if ( modelAndView == null ) {	return;  	}
		
		if ( modelAndView.isRedirect()) {
			response.sendRedirect(modelAndView.getView());
		} else {
			request.getRequestDispatcher( modelAndView.getView()).forward(request, response);
		}	
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
