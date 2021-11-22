package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.free.FreeInsertService;
import service.free.FreeListService;
import service.free.FreeService;
import service.free.FreeUpdateService;
import service.free.FreeViewService;


@WebServlet("*.free")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FreeController() {
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
	
		FreeService service = null;
		ModelAndView mav = null;
		
		switch(command) {
		case "list.free":
			service = new FreeListService();
			break;
		case "insertForm.free":
			mav = new ModelAndView("free/insert.jsp", false);
			break;
		case "insert.free":
			service = new FreeInsertService();
			break;
		case "view.free":
			service = new FreeViewService();
			break;
		case "updateForm.free":
			mav = new ModelAndView("free/update.jsp", false);     // redirect 불가능 (f의 fno와 content가지고 가므로)
			break;
		case "update.free":
			service = new FreeUpdateService();
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
