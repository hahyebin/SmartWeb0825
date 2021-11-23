package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StaffInsertService;
import service.StaffListService;
import service.StaffService;


@WebServlet("*.do")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  
		
		// JSP 요청 확인 
		String requestURI= request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		StaffService service = null;
		
		switch(command) {
		case "listStaff.do":
			service = new StaffListService();
			break;
		case "staffInsert.do":
			service = new StaffInsertService();
			break;
		}
		
		if(service != null){
			service.execute(request, response);   // 반환 타입이 없음
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
