package service.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardUpdateService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		// realPath 
		String path = (String)session.getAttribute("path");
		String realPath = request.getServletContext().getRealPath(path);
		
		// MultipartRequest 객체 생성
		// 파일의 폼을 보내느 것이기 때문에 servletrequest 말고 multipartrequest에서 파라미터를  가지고 와야한다.!!
		MultipartRequest mr = new MultipartRequest(request, realPath, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy()  );
		
		/** 첨부 파일 수정 **/
		// 기존에 첨부되어 있던 파일
		String saveName = mr.getParameter("saveName");
		File previous = new File(realPath,  saveName);
		
		// 새로 첨부하려는 파일 ( 새로 첨부할 파일을 jsp에서 보내면 getFile() 메소드를 사용해서 바로 꺼낼 수 있다.)
		File present = mr.getFile("fileName");
		
		// 새 첨부가 있으면 기존 첨부를 지움 
		if (present != null ) {
			if( previous.exists() ) { previous.delete(); }			
		}
		
		/** DB 수정 **/
		// 수정할 게시글 정보
		Long bNo = Long.parseLong(mr.getParameter("bNo"));
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		// DB로 보낼 Board(수정 내용을 저장한 board)
		Board board = new Board();
		board.setbNo(bNo);
		board.setTitle(title);
		board.setContent(content);
		if( present != null ) {  		   // 새첨부가 있으면 올린이름, 저장이름 모두 변경 / 새첨부가 없으면 기본 첨부명 사용
			board.setFileName(mr.getOriginalFileName("fileName"));  // 올린이름
			board.setSaveName(mr.getFilesystemName("fileName"));    // 저장된 이름   
		}
		int result = BoardDao.getInstance().updateBoard(board);
		
		// 결과 확인하기
		PrintWriter out = response.getWriter();
		if( result > 0) {
			out.println("<script>");
			out.println("alert('게시글 수정 성공')");
			out.println("location.href='view.board?bNo=" + bNo + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 수정 실패')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		
		return null;
	}

}
