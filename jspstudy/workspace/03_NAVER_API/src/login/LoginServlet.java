package login;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = GetKey.getKey();
		request.setAttribute("key", key);    // login.jsp에 있는 key의 값과 일치해야하는 key
		GetImage.getImage(key, request); // 참조변수는 주소를 참조하기 때문에 주는 곳 받는곳은 일치함 
	//	request.getServletContext().getRealPath(path)   //servlet에서 리얼패스 구하는 법( = jsp에선 application.realPath())
		// 로그인 링크 누르면 키와 이미지 받아옴 -> 로그인 화면 이동 
		// 로그인 화면으로 가서 이미지 보여줘야 함 
		
		// 포워드 : request가지고 이동 : request에 파일명 저장      
		// 포워드는 객체를 그대로 가지고 간다 
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
