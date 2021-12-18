package com.koreait.ex15.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface BoardService {
   
	// 게시글 등록
	public Map<String, Object> addBoard(MultipartHttpServletRequest multipartRequest);
	
}
