package service.board;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardInsertService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// 첨부파일이 저장될 디렉터리 
		// storage/년도/월/일   순으로 하위폴더가 생성된다
		String year = new SimpleDateFormat("yyyy").format(new Date());
		String month = new SimpleDateFormat("MM").format(new Date());
		String day = new SimpleDateFormat("dd").format(new Date());
		
		String path = "storage" + File.separator + year + File.separator + month + File.separator + day;
		String realPath = request.getServletContext().getRealPath(path);
		File dir = new File(realPath);
		if( !dir.exists()) {
			dir.mkdirs();      // 상위폴더까지 함께 생성 mkdirs    //  상위폴더필요없으면 mkdir
		}
		
		// 첨부업로드 
		MultipartRequest mr = new MultipartRequest(request, realPath, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy() );
		
		// 파라미터 처리
		String writer = mr.getParameter("writer");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String fileName = mr.getOriginalFileName("fileName");    // 올릴 때 파일이름 fileName => 받기는 parameter 아니고 orifinalFileName
		String saveName = mr.getFilesystemName("fileName");      // 실제 저장할 때 파일 이름  fileName => 저장된 이름 갖고 올 때는 FilesystemName        
		
		// DB로 보낼 Board
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setFileName(fileName);
		board.setSaveName(saveName);    
		
		
		//System.out.println(board.toString());
		
		Logger logger = Logger.getLogger(BoardInsertService.class.getName());
		logger.info(board.toString());
		
		// DB에 삽입
		int result = BoardDao.getInstance().insertBoard(board);
		
		PrintWriter out = response.getWriter();
		if( result > 0) {
			out.println("<script>");
			out.println("alert('게시글 등록 성공')");
			out.println("location.href='list.board'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 등록 실패')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
