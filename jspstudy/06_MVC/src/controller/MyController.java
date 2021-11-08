package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.Circle;
import model.Rectangle;
import model.Shape;


// URLMapping의 suffix인 .do인 모든 요청을 처리하는 컨트롤러 
@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// URLMapping 확인   -> request.getReqeustURI() 
		String requestURI =  request.getRequestURI();
		String command =  requestURI.substring(requestURI.lastIndexOf("/")+1);
		
		// 모든 model은 Shape 인터페이스를 구현한다.
		Shape shape = null;
		
		// ModelAndView 선언 
		ModelAndView modelAndView = null;
		
		//command에 따른 model선택 
		switch(command) {
		case "rectangle.do":
			shape = new Rectangle();		
			break;
		case "circle.do":
			shape = new Circle();	
			break;
		case "input.do":
			modelAndView = new ModelAndView();
			modelAndView.setView("views/input.jsp");  //   = /MVC2/views/input.jsp
			modelAndView.setRedirect(true);  //담을 데이터 없으므로 바로 설정해서 이동함     //  forward의 경우 서버간이동이므로 사용자 측에 input.do가 url에 찍힘 
			break;
		}
		
		
	   //  shape.execute(request, response)의 메서드는  모델앤뷰 객체를 리턴함 
		if( shape != null ) {   // shape객체가 있는 경우에만 execute() 실행해서 데이터 담고 모델앤뷰 객체를 리턴함 
			modelAndView = shape.execute(request, response);
		}  
	
		
		// modelAndView가 없는 경우 (ajax 처리)
		// Model이 직접 결과를 반환하는 경우 => response를 직접 작업하는 경우
		if( modelAndView == null ) {
			return;
		}
		// modelAndView가 있는 경우 (ajax 처리가 아닌 모든 경우)
		if(modelAndView.isRedirect() ) { // redirect로 갈 경우 
			response.sendRedirect(modelAndView.getView());  // 이동할 곳 갖고오기 
		} else {   // forward로 갈 경우 
			request.getRequestDispatcher(modelAndView.getView()).forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


// public  protected->같은패키지+상속    default  private->클래스