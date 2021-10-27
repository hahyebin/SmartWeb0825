package prac1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 10/27 퀴즈1 복습하기!!!!  



/**
 * Servlet implementation class Prac1
 */
@WebServlet("/Prac1")
public class Prac1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prac1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//요청 인코딩 
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터는 "cmd"로 같음!!!
	
		//date 객체 
		// 1) if 로 null일 때 처리 
		String cmd = request.getParameter("cmd");
		if( cmd == null ) {
			cmd = "now";
		}
		// 2) Optional로 null일 때 처리
//		Optional<String> optCmd = Optional.ofNullable(request.getParameter("cmd"));
//		String cmd = optCmd.orElse("today");
		
		LocalTime lt = LocalTime.now();
		LocalDate ld = LocalDate.now();
		
		
		// 브라우저에 반환환 결과값
		String result = null;
		if( cmd.equals("now")) {
			result = lt.getHour()+":" +lt.getMinute()+":"+lt.getSecond(); 
		} else if ( cmd.equals("today")){
			result = ld.getYear() +"년 "+ ld.getMonthValue() +"월  "+ld.getDayOfMonth()+"일";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+result+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
