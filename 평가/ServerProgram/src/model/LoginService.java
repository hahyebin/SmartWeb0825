package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 받기.
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		// 설정
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setName(name);
		
		ModelAndView mav = null;
		// 테이블에서 갖고오기
		MemberDTO mem = MemberDAO.getInstance().select(member);
		
		// 있으면 세션저장하고 이동
		if (mem != null) {
			request.getSession().setAttribute("member", mem);
			mav = new ModelAndView("views/manager.jsp", false);  //이동
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이름을 확인하세요')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return mav;
	}

}
