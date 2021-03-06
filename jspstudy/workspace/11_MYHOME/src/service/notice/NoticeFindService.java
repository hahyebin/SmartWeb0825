package service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import common.Page;
import dao.NoticeDao;
import dto.Notice;

public class NoticeFindService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 처리
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		// DB로 보낼 HashMap
		Map<String, String>  map = new HashMap<String, String>();
		map.put("column", column);
		map.put("query", "%"+query+"%");       // 사용자가 입력한 query가 어느 자리에서나 검색 가능하도록 미리 만능문자 %를 붙여서 DB로 전송 
		
		
		
		
		// 페이징1. 검색된 공지사항 갯수 구하기
		int totalRecord = NoticeDao.getInstance().selectFindCount(map);
		
		// 페이징2. 현재 페이지 번호 확인하기
		// page가 안 넘어오면 page = 1로 처리함.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
	
		// 페이징3. 페이징에 필요한 모든 계산 처리하기
		Page p = new Page();
		p.setPageEntity(totalRecord, page);
		
		// 페이징4. String으로 < 1 2 3 4 5 > 만들기
		String pageEntity = p.getPageEntity("find.notice?column="+column+"&query="+query);        // 찾기를 하기위해 column과 query를 추가해서 보낸다.
		
		// 페이징5. DB로 보낼 beginRecord, endRecord 작업 
		map.put("beginRecord", p.getBeginRecord()+"");
		map.put("endRecord", p.getEndRecord()+"");
		
		
		
		// 검색 결과 가져오기
		List<Notice> list = NoticeDao.getInstance().findNotice(map);
		
		// list.jsp 보낼 데이터들
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("pageEntity", pageEntity);
		request.setAttribute("list", list);   // 전체 리스트에서도 list로 활용해서 list.jsp에서도 jstl로 list를 활용해서 작성했기 때문에 이름을 맞춘다.
		request.setAttribute("startNum", totalRecord - (page - 1) * p.getRecordPerPage());
		
		
		return new ModelAndView("notice/list.jsp", false);
	
	}
}
