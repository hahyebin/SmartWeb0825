package com.koreait.ex14.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex14.domain.Employee;
import com.koreait.ex14.repository.EmployeeRepository;
import com.koreait.ex14.util.PageUtils;

public class EmployeeServiceImpl implements EmployeeService {
  
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void findAllEmployee(Model model) {
	    EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
	    
	    // Model에 저장된 request 꺼내기
	    Map<String, Object> m  = model.asMap();
	    HttpServletRequest request = (HttpServletRequest)m.get("request");
	    
	    // 전체 레코드 갯수
		int totalRecord = repository.selectTotalRecordCount();
		logger.info(totalRecord+"");
		
		// 전달된 페이지 번호( 전달 안되면 page = 1 사용)
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 페이징 처리 Page 객체 생성 및 계산
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);   // 전체 페이지수, 각  페이지 첫,끝 게시물번호, 페이지 적힌 블락 맨 첫번호 끝번호
		
		// beginRecord + endRecord => map에 넣기 
		Map<String, Object> map = new HashMap<>();
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		// beginRecord ~ endRecord 목록 가져오기
		List<Employee> list = repository.selectEmployeeList(map);
		
		
		// View(employee/list.jsp)로 보낼 데이터
		// pageEntity
		model.addAttribute("list", list);
		model.addAttribute("startNum", totalRecord - (page -1 ) * pageUtils.getRecordPerPage());
		model.addAttribute("paging", pageUtils.getPageEntity("findAll"));  // 목록을 출력하는 매핑값 전달
		model.addAttribute("totalRecord", totalRecord);
	
	}
	
	
	// 검색한 직원 수와 목록
	@Override
	public void FindEmployee(Model model) {
		
		  EmployeeRepository repository = sqlSession.getMapper(EmployeeRepository.class);
		    
		    // Model에 저장된 request 꺼내기
		    Map<String, Object> m  = model.asMap();
		    HttpServletRequest request = (HttpServletRequest)m.get("request");
		    
		    // column + query => HashMap(검색할 칼럼 + 검색어)
		    Map<String, Object> map = new HashMap<>();
		    String column =request.getParameter("column");
		    String query = request.getParameter("query");
		    map.put("column",column);   // 검색할 칼럼
		    map.put("query", query);     // 검색어
		    
		    // 검색된 레코드 갯수
			int totalRecord = repository.selectFindRecordCount(map);
			logger.info("검색된 수 " +totalRecord);
			
			// 전달된 페이지 번호( 전달 안되면 page = 1 사용)
			Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
			int page = Integer.parseInt(opt.orElse("1"));
			
			// 페이징 처리 Page 객체 생성 및 계산
			PageUtils pageUtils = new PageUtils();
			pageUtils.setPageEntity(totalRecord, page);   // 전체 페이지수, 각  페이지 첫,끝 게시물번호, 페이지 적힌 블락 맨 첫번호 끝번호
			
			
			// 기존map + beginRecord + endRecord => map에 넣기 
			map.put("beginRecord", pageUtils.getBeginRecord());
			map.put("endRecord", pageUtils.getEndRecord());
			
			// 검색된 목록 중  beginRecord ~ endRecord 사이 목록 가져오기
			List<Employee> list = repository.selectFindList(map);
			
			
			// View(employee/list.jsp)로 보낼 데이터
			// pageEntity
			model.addAttribute("list", list);
			model.addAttribute("startNum", totalRecord - (page -1 ) * pageUtils.getRecordPerPage());
			model.addAttribute("totalRecord", totalRecord);
			
			// 검색 조건에 따라서 모델(jsp로 보내는) 에 저장해서 보내는 파라미터가 달라진다.
			// salary는 query가 아니라 max, min을 갖고오기 때문에 if문 처리를 통해 다른 파라미터 값을 설정 해야한다.
			switch (column) {
			case "EMPLOYEE_ID":
				model.addAttribute("paging", pageUtils.getPageEntity("findEmployee?column="+column +"&query="+query ));  // 검색된 목록을 출력하는 매핑값 전달
				break;	
			case "FIRST_NAME":
				model.addAttribute("paging", pageUtils.getPageEntity("findEmployee?column="+column +"&query="+query ));  // 검색된 목록을 출력하는 매핑값 전달
				break;	
			}
	}
	
	

} // end of class












