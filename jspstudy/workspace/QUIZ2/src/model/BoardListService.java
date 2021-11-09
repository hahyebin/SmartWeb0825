package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		request.setAttribute("boardList", boardDAO.selectList());     // ArrayList에 있는 boardList 설정
		
		return new ModelAndView("views/BoardList.jsp", false);       // 조회, 검색은 forward
		

	}

}
