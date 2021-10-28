package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz2_answer
 */
@WebServlet("/Quiz2_answer")
public class Quiz2_answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2_answer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 인코딩 
		request.setCharacterEncoding("utf-8");
		String date = request.getParameter("date");
		String from = request.getParameter("from");
		if(from.isEmpty()) {
			from = "하혜빈";
		}
		String to = request.getParameter("to");
		if(to.isEmpty()) {
			to = "수지";
		}
		String content = request.getParameter("content");
		if(content.isEmpty()) {
			content = "안녕하세요 반갑습니다.";
		}
		// 참고 : 이렇게 데이터를 받은 경우(게시글, 파일생성) 사용자의 아이피주소를 받음!
		// 작성자 IP 알아내는 법 
		// 1. 직접 접속한 경우 : request.getRemoteAddr();
		// 2. 거쳐서 접속한 경우 : request.getHeader("X-Forwarded-For")
		String ip = request.getHeader("X-Forwarded-For");
		if( ip == null ) {
			ip = request.getRemoteAddr();  // ip가 거쳐진게 아니라면 ip는 null값이기 때문에 직접 접속한 경우로 값 넣는다.
		}
		// 파일명 
		String filename = date+"_"+from+".txt";
		
		// ① 디렉터리
		File dir = new File( "D:\\SmartWeb0825-main\\jspstudy\\01_SERVLET\\workspace\\storage");
		if(dir.exists() == false ) {
			dir.mkdirs();
		}
		
		// ② 파일 저장 경로 (File parent : folder => mkdir() );
		File file = new File(dir, filename);
		
		// 문자 기반 출력 스트림 생성 
		// FileWriter, PrintWriter, BufferedWriter(성능제일좋음) 등 
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 데이터 보내기
		bw.write("작성일 : " +date+"\n");
		bw.write("보내는사람 : " +from+"\n");
		bw.write("받는사람 : " +to+"\n");
		bw.write(content+"\n");
		
		// 스트림 닫기 
		if( bw != null ) { bw.close(); }
		
		// 응답 
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+file.getAbsolutePath()+"파일이 생성되었습니다.')");
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
