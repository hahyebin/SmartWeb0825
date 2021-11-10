package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardAllList;
import model.BoardDelete;
import model.BoardInsert;
import model.BoardOneList;
import model.BoardService;
import model.BoardUpdate;

@WebServlet("*.do")
public class BoardMSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BoardMSController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String command =  request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
	
		ModelAndView mav = null;
		BoardService bs = null;
		
		switch(command){
		case "/boardAllList.do":            // 전체게시글 
			bs = new BoardAllList();
			break;
		case "/insertForm.do":              // 새글
			mav = new ModelAndView("views/boardInsert.jsp", false);
			break;
		case "/boardInsert.do":            // 게시글삽입
			bs = new BoardInsert();
			break;
	
		case "/boardOneList.do":           // 게시글 상세보기
			bs = new BoardOneList();
			break; 
		case "/boardModify.do":			   // 게시글 수정 
			bs = new BoardUpdate();
			break;
		case "/boardDelete.do":			  // 게시글 삭제
			bs = new BoardDelete();
			break;
		}
		
		if( bs != null ) {
			mav =  bs.execute(request, response);
		}
		
		// model에서 response로 직접 이동한 경우 
		if( mav == null ) { return; }
		
		//redirect 또는 forward로 이동
		if( mav.isRedirect() ) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
