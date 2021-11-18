package service.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeListService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		// 상세보기할 때 sessionㅇ ㅔ 올려둔  notice를 제거 
		Notice notice = (Notice) session.getAttribute("notice");
		
		if(notice != null) {
			session.removeAttribute("notice");
		}
		
		// 상세보기할 대 session에 올려 둔 open 제거
		if(session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		
		List<Notice> list = NoticeDao.getInstance().selectNoticeList();
		request.setAttribute("list",list );
	
		return new ModelAndView("notice/list.jsp", false);
	}

}