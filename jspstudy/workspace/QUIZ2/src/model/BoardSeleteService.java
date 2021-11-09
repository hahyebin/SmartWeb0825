package model;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class BoardSeleteService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		request.setAttribute("board", boardDAO.selectDTO(idx));
		
		return new ModelAndView("views/BoardUpdate.jsp",false);     // 조회는 forward
	}

}
