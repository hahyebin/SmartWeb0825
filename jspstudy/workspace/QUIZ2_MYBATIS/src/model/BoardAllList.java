package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class BoardAllList implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		request.setAttribute("boards",dao.selectList());
		request.setAttribute( "count", dao.getCount());
		
		
		return new ModelAndView("views/boardList.jsp", false);
	}

}
