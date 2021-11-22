package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLeaveService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// 탈퇴할 회원  정보 가져오기 (아이디와 번호를 세션에 저장한게 아니라 멤버객체를 세션에 저장한 것이므로 유저 정보를 꺼내서 그곳의 아이디와 번호를꺼낸다.)
		 HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		 
		 // 삭제 
		 // 1) 멤버로그삭제
	//	 MemberDao.getInstance().deleteMemberLog(loginUser.getId());   / DB에 on delete cascade 옵션 때문에 주석 처리해도 자동 삭제 가능 
		 // 2) 멤버삭제
		 int result = MemberDao.getInstance().deleteMember(loginUser.getmNo());
		 
		 PrintWriter out = response.getWriter();
		if( result > 0 ) {
			// session 정보 제거 후 메시지 뜨ㅣ우고 이동
			 session.invalidate();
			 
			out.println("<script>");
			out.println("alert('회원탈퇴 성공')");
			out.println("location.href='index.jsp'");
			out.println("</script>");
			out.close();
			
		} else {
			out.println("<script>");
			out.println("alert('회원탈퇴 실패')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return null;
	}
}
