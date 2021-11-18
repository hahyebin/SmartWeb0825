package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.BBoardService;
import common.ModelAndView;
import dao.bBoardDao;
import dto.bBoard;

public class SelectAllList implements BBoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		bBoard board =  (bBoard)(session.getAttribute("board"));
		// 리스트로 되돌아와서 게시글 있으면 세션삭제하고 다시 시작
		if (session.getAttribute("board") != null) {
			session.removeAttribute("board");
		}
		request.setAttribute("id", request.getParameter("writer"));
		request.setAttribute("pwd", request.getParameter("pwd"));
		
		request.setAttribute("list", bBoardDao.getInstance().selectlist());
		request.setAttribute("cnt", bBoardDao.getInstance().getCount());
		
		// 데이터 갖고 이동하기 
		return new ModelAndView("views/bselectlist.jsp", false);
	}

}
