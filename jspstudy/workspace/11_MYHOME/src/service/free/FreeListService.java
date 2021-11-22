package service.free;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class FreeListService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// 조회수 증가에서 사용된 session의 open 속성 제거하기
		HttpSession session = request.getSession();
		if( session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		
		// 게시글 리스트 
	    List<Free> list = FreeDao.getInstance().selectFreeList();
	    
	    // 기록남기기
	    Logger logger =  Logger.getLogger(FreeListService.class.getName());
	    logger.info(list.toString());
	    
	    // 게시물 수 
	    int totalCount = FreeDao.getInstance().selectTotalCount();
	    
	    // 리퀘스트 저장하기
	    request.setAttribute("totalCount", totalCount);
	    request.setAttribute("list", list);
		
		return new ModelAndView("free/list.jsp", false);
	}

}
