package com.koreait.ex08.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex08.domain.Contact;
import com.koreait.ex08.service.ContactService;

@Controller
@RequestMapping("contact")
public class ContactController {
	// ct - > 컨트롤러 -> 서비스 -> 레파지토리 -> 디비
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	// field
	@Autowired   // controller는 service와 의존관계이다
	private ContactService service;
	
	
	// method
	@GetMapping("findAllContact")
	public String findAllContact(Model model) {
		model.addAttribute("list", service.findAllContact());
		return "contact/list";
	}
	
	//등록하러 가기 위한 폼
	@GetMapping("contactPage")
	public String contactPage() {
		return "contact/insert";
	}
	
	//등록
	@PostMapping("addContact")
	public String addContact(Contact contact) {
		service.addContact(contact);
		return "redirect:findAllContact";
	}
	
	
	// 수정하러가기
	@GetMapping("findContact")
	public String findContact(Contact contact, Model model) {
		model.addAttribute("contact", service.findContact(contact));
		return "contact/detail";
	}
	
	// 수정
	@GetMapping("updateContact")
	public String updateContact(Contact contact) {
		service.updateContact(contact);
		return "redirect:findContact?no="+contact.getNo();
	}
	
	// 삭제 
	@GetMapping("deleteContact")
	public String deleteContact(Contact contact) {
		service.deleteContact(contact);
		return "redirect:findAllContact";
	}
	
}
