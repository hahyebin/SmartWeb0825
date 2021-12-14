package com.koreait.ex14.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex14.service.EmployeeService;

@Controller
@RequestMapping("search/*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("searchPage")
	public String searchPage() {
		return "employee/list";
	}
	
	
	@GetMapping("findAll")
	public String findAll(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.findAllEmployee(model);
		return "employee/list";
	}
	
	@GetMapping("findEmployee")
	public String findEmployee(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.FindEmployee(model);
		return "employee/list";
	}
	
	
	
}
