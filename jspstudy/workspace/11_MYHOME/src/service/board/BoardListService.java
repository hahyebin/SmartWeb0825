package service.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		request.setAttribute("list", BoardDao.getInstance().selectBoardList());
		
		
		
		
//		
//		String filename = Long.valueOf((new Date()).getTime()).toString() + ".jpg";   // Long.valueOf((new Date()).getTime()) 다운 시간 
//		File file = new File(dir, filename);
//		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
//		byte[] b = new byte[1024];
//		int readCount = 0;
//		while( true) {
//			readCount = bis.read(b);   // bis.read(b)를 읽다가 읽을게 없으면 -1이 되고 그때 멈춰야함!!
//			if( readCount == -1 ) {
//				break;
//			}
//			bos.write(b, 0, readCount);  // b배열에서 0인덱스부터 실제로 읽은 만큼만 읽겠다 // -> 그냥 읽으면 실제 읽지 않은 나머지 1024-x 만큼을 갖고온다 즉 쓰레기를 갖고옴 그래서 실제 바이트를 갖고 오게하기 위해 readCount를 변수를 만든다. 
//		}
//	
//		if( bos != null) { bos.close();  }
//		if( bis != null) { bis.close();  }
//		
//		// LoginServlet의 request ->GetImage로 전달 
//		// 그러면 LoginServlet과 GetImage의 request는 완전히 같다.
//		request.setAttribute("filename", filename);
//		request.setAttribute("folderName", folderName);
//		
//		
		
		
		
		
		
		
		
		
		
		
		
		return new ModelAndView("board/list.jsp", false);
	}

}
