package model2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.BBoardService;
import common.ModelAndView;
import dao.RReplyDao;
import dao.bBoardDao;
import dto.Rreply;
import dto.bBoard;

public class ReplyInsertService implements BBoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Long idx = Long.parseLong(request.getParameter("idx"));
		
		Rreply reply = new Rreply();
		reply.setWriter(writer);
		reply.setContent(content);
		reply.setIdx(idx);
		
		int result = RReplyDao.getInstance().insertReply(reply);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
			

		return null;
	}

}
