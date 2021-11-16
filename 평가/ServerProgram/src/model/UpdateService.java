package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		int no = Integer.parseInt(optNo.orElse("0"));
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDTO mem = new MemberDTO();
		if(point >= 5000) {
			mem.setGrade("vip");
		} else if(point >=4000) {
			mem.setGrade("gold");
		} else if( point >= 3000) {
			mem.setGrade("silver");
		} else {
			mem.setGrade("bronze");
		}
		
		mem.setNo(no);
		mem.setName(name);
		mem.setPoint(point);
	
		int result = MemberDAO.getInstance().update(mem);
		
		PrintWriter out = response.getWriter();
		if( result > 0 ) {
			if( result > 0) {
				out.println("<script>");
				out.println("alert('수정 성공')");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('수정 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		
	}
		return null;
 }
}

