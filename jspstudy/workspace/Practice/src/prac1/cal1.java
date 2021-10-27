package prac1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cal1
 */
@WebServlet("/cal1")
public class cal1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cal1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// 요청값 인코딩
		request.setCharacterEncoding("utf-8");
		
		String strX = request.getParameter("x");
		String strY = request.getParameter("y");
		if( strX == null || strX.equals("") ) {
			strX = "0";
		}
		if( strY == null || strY.equals("") ) {
			strY = "0";
		}
		int x = Integer.parseInt(strX);
		int y = Integer.parseInt(strY);
		
		// 응답값 인코딩 
		response.setContentType("text/html; charset=utf-8");
	    
		PrintWriter out = response.getWriter();
		out.println("<http>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>첫번째 값 + 두번째 값 : "+(x+y)+"</p>");
		out.println("<p>첫번째 값 - 두번째 값 : "+(x-y)+"</p>");
		out.println("<p>첫번째 값 x 두번째 값 : "+(x*y)+"</p>");
		out.println("<p>첫번째 값 / 두번째 값 : "+(x/y)+"</p>");
		out.println("</body>");
		out.println("</http>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
