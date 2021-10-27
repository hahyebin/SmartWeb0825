package quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz2
 */
@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// request 인코딩
		request.setCharacterEncoding("UTF-8");
		
	    // 파라미터의 값 자바변수에 저장!
		String date = request.getParameter("date");        // <form> date파라미터의 값을 자바 String date에 저장!
		String from = request.getParameter("from");        // <form> from파라미터의 값을 자바 String from에 저장!
		String to_ = request.getParameter("to");     	   // <form> to파라미터의 값을 자바 String to_에 저장!
		String content =  request.getParameter("content"); // <form> content파라미터의 값을 자바 String content에 저장!
		// -> 동작실행 완료// 
		
		
		// response 인코딩 
		response.setContentType("text/html; charset=UTF-8");
		
		
		// 파일생성하기! 
		String dir = "D:\\SmartWeb0825-main\\jspstudy\\workspace\\01_SERVLET\\src\\";
		String fileName = date+"_"+from+".txt";
		String file = dir+fileName;
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			System.out.println("파일생성성공");
			writer.write("작성일: "+date+"\n");
			writer.write("보내는사람: "+from+"\n");
			writer.write("받는사람: "+to_+"\n");
			writer.write(content+"\n");
			writer.close();
			System.out.println("파일 쓰기성공");
		} catch(IOException e) {
			System.out.println("파일생성실패");
			System.out.println("파일 쓰기 실패");
		}
	    
		
		// 생성 및 쓰기 생성완료 알림창 
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+fileName+" 생성이 되었습니다');");
		out.println("</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
