package com.koreait.ex10.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex10.domain.Notice;
import com.koreait.ex10.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {
  
	// controller(service연결 Autowired) - service(repository연결 Autowired) - repository(DB연결 Autowired) - db
	
	@Autowired
	private NoticeService service;
	
	@GetMapping("selectNoticeList")
	public String selectNoticeList(Model model) {
	    model.addAttribute("list",  service.selectNoticeList());   // model에 저장된 list가지고 notice.list로 이동한다
		return "notice/list";
	}
	
	@GetMapping("noticePage")
	public String noticePage() {
		return "notice/insert";
	}
	
	@PostMapping("insertNotice")            // request, response, session 사용위해서는 controller의 매개변수에 선언만 하자
	public void insertNotice(Notice notice, HttpServletResponse response) {
		 service.insertNotice(notice, response);    // controller에서 받아온거 service 전달하면 service가  응답함 
	}
	
	
	// 상세보기 및 수정화면 이동
	@GetMapping("selectNoticeByNo")
	public String selectNoticeByNo(@RequestParam Long no, Model model) {
		model.addAttribute("notice", service.selectNoticeByNo(no));   //  service.selectNoticeByNo(no) 의 반환값은 notice 객체이다.
		return "notice/detail";
	}
	
	// 수정하기
	@GetMapping("updateNotice")
	public void updateNotice(Notice notice, HttpServletResponse response) {
	    service.updateNotice(notice, response);
	}
	
	// 삭제하기
	@GetMapping("deleteNotice")
	public void deleteNotice(Notice notice, HttpServletResponse response, Model model) {
		service.deleteNotice(notice.getNo(), response);
	}
	
	
	
}
