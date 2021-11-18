package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.BBoardService;
import common.ModelAndView;
import dao.bBoardDao;
import dto.bBoard;

public class UpdateService implements BBoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String strIdx = request.getParameter("idx");
		Long idx = Long.parseLong(strIdx);
		  
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		bBoard board = new bBoard();
		board.setIdx(idx);
		board.setTitle(title);
		board.setContent(content);
		
		int result = bBoardDao.getInstance().updateboard(board);
		
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
	
		return null;
	}

}
