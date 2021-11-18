package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.notice.NoticeService;
import service.reply.ReplyInsertService;
import service.reply.ReplyService;


@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ReplyController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청/응답 기본 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// JSP 요청 확인 
		String requestURI= request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
	
				
		ReplyService service = null;
		ModelAndView mav = null;
		
		switch(command) {
		case "insert.reply":
			service = new ReplyInsertService();
			break;
		}
		
		// service 가 사용되지 않은 경우 (단순 이동) service 실행이 불가능 
		if (service != null ) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// mav가 null인 경우
		// 1. Model(Service)에서 응답으로 이동하는 겨우 
		// 2. Model(Service)가 ajax 응답을 하는 경우
		if (mav == null ) return;
		
		// mav 가 null이 아닌 경우 : MVC 패턴으로 페이지 이동이 있음		
		if( mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
				

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
