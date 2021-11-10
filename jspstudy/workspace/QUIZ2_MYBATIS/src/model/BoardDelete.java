package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class BoardDelete implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.delete(idx);
		
		ModelAndView modelAndView = null;
		
		if(result > 0) {
			modelAndView = new ModelAndView("/Q_MYBATIS/boardAllList.do",true);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		
		return modelAndView;
	}

}
