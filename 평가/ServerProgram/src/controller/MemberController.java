package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.JoinService;
import model.ListService;
import model.LoginService;
import model.LogoutService;
import model.MemberService;
import model.OutofService;
import model.UpdateService;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();     					
		String contextPath = request.getContextPath();   					
		String command = requestURI.substring(contextPath.length()+1);    
		
		ModelAndView mav = null;
		MemberService service = null;
		
		switch(command) {
		case "list.do" :                   // 전체목록 서비스
			service = new ListService();
			break;
		case "loginPage.do":               // 로그인화면이동
			mav = new ModelAndView("views/login.jsp",false);
			break;
		case "login.do":                   // 로그인 서비스
			service = new LoginService();
			break;
		case "logout.do":                 // 로그아웃 서비스
			service = new LogoutService();
			break;
		case "join.do":                   // 회원가입 서비스
			service = new JoinService();
			break;
		case "outof.do":                 // 탈퇴 서비스
			service = new OutofService();
			break;
		case "update.do":               // 수정 서비스
			service = new UpdateService();
			break;
		}
		
		if( service != null ) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(mav == null ) return;
	
		if(mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else { 
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}

	} // end of deGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
