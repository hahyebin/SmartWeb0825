package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lotto;
import model.Now;
import model.Today;
import model.GuGudan;


@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;  

    public MyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/* 요청 확인 */
		// request.getRequestURI()  요청 확인하기위한 용도 
		int begin = request.getRequestURI().lastIndexOf("/");
		String command = request.getRequestURI().substring(begin+1);   // begin -> /today.do or /now.do    begin+1 => today.do or now.do
	
		switch(command) {
		case "today.do":
			Today today = new Today();
			today.excute(request, response);
			today.ec(request, response);
			break;
		case "now.do":
			Now now = new Now();
			now.excute(request, response);
			break;
		case "lotto.do":
			Lotto lotto = new Lotto();
			lotto.excute(request, response);
			break;
	        case "gugudan.do":
			GuGudan gugudan = new GuGudan();
			lotto.excute(request, response);
			break;
		}
		
		/* 응답 view 로이동 */ 
		//request 를 전달하는 forward
		// 각 Model이 request 에 결과를 저장해둠 
		request.getRequestDispatcher("/views/output.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
