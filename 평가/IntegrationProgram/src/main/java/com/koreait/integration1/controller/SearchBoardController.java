package com.koreait.integration1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration1.domain.SearchBoard;
import com.koreait.integration1.service.SearchService;
import com.koreait.integration1.service.SearchServiceImpl;

@Controller
public class SearchBoardController {
		
	  private final static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
		@Autowired
		private SearchService service;
		
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		
		// 목록
		@GetMapping(value="/movie/findAllMovie", produces = "application/json; charset=UTF-8")
		@ResponseBody
		public 	Map<String, Object> findAllMovie() {
			List<SearchBoard> list = service.findAllMovie();
			Map<String,Object> map = new HashMap<>();
			
			if(list.size() == 0) {
				map.put("status", 500);
				map.put("message", "게시판이 이 없습니다");
				map.put("list", null);
			} else {
				map.put("status", 200);
				map.put("message", "전쳬 "+list.size() +"개의 목록을 가져왔습니다");
				map.put("list", list);
			}
		    logger.info(map.toString());
			return map;
		}
		
		// 검색 
		@GetMapping(value="movie/findMovie", produces =  "application/json; charset=UTF-8")
		@ResponseBody
		public Map<String, Object> findBook(HttpServletRequest request){
			Map<String, Object> map = new HashMap<>();
			map.put("column", request.getParameter("column"));
			String query = request.getParameter("query");
			map.put("query",query);
			
			List<SearchBoard> list = service.findMovie(map);
			Map<String,Object> m = new HashMap<>();
			if(list.size() == 0) {
				m.put("status", 500);
				m.put("message", query +"의 검색 결과가 없습니다");
				m.put("list", null);
			} else {
				m.put("status", 200);
				m.put("message", list.size() +"개의 검색 결과가 있습니다");
				m.put("list", list);
			}
		
			 logger.info(m.toString());
			 logger.info(list.size()+"");
			 
			return m;
		}
		
		
		
		
		
}
