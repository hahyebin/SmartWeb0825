package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;

public class LogoutService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		// 세션삭제
		 session.removeAttribute(name);
	     session.removeAttribute(id);
			
		
		// 로그아웃하면 list.do 응답하는 index로 이동..
		return new ModelAndView("index.jsp",false);
	}

}
