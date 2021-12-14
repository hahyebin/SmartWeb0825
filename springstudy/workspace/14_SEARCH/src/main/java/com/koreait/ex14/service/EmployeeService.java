package com.koreait.ex14.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface EmployeeService {
       
	// 전체직원가져오기
	public void findAllEmployee(Model model);
	
	// 검색 된 직원 가져오기(총 수, 목록)
	public void FindEmployee(Model model);
	
	
}
