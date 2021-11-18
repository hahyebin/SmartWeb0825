package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.notice.NoticeDeleteService;
import service.notice.NoticeInsertService;
import service.notice.NoticeListService;
import service.notice.NoticeService;
import service.notice.NoticeUpdateService;
import service.notice.NoticeViewService;


@WebServlet("*.notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청/응답 기본 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// JSP 요청 확인 
		String requestURI= request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
	
		// 모든 Model은 인터페이스 NoticeService를 구현하므로
		// NoticeService 타입의 객체이다. 
		NoticeService service = null;
		
		//  ModelAndView 객체 선언
		// 1. 단순 이동 요청을 처리
		// 2. 모든 Model(Service)는 ModelAndView를 반환
		ModelAndView mav = null;
		
		// command에 따라 요청되는 것이 달라짐
		// 해당 요청을 처리할 Model(Service) 선택
		switch(command) {
		case "list.notice":                                       // 전체 리스트
			service = new NoticeListService();
			break;
		case "view.notice":                                       // 상세보기
			service = new NoticeViewService();
			break;
		case "insertForm.notice":
			mav = new ModelAndView("notice/insert.jsp", false);   // 단순이동 포워드
			break;
		case "insert.notice":                                     // 새글 등록
			service = new NoticeInsertService();
			break;
		case "updateForm.notice":
			mav = new ModelAndView("notice/update.jsp", false);     // 수정입력할수있는곳으로 세션에 저장되어있으므로 데이터 직접 입력 안되도 됨
			break;
		case "update.notice":
			service = new NoticeUpdateService();
			break;
		case "delete.notice":
			service = new NoticeDeleteService();
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
