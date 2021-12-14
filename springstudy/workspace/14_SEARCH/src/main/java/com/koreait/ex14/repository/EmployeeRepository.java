package com.koreait.ex14.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koreait.ex14.domain.Employee;
@Repository
public interface EmployeeRepository {

	
        // 전체 직원 수  	
		public int selectTotalRecordCount();
		
		// 직원 목록 가져오기
		public List<Employee> selectEmployeeList(Map<String, Object> map);
		
		// 검색 직원 수 
		public int selectFindRecordCount(Map<String, Object> map);
		
	    // 검색 목록 
		public List<Employee> selectFindList(Map<String, Object> map);
}
