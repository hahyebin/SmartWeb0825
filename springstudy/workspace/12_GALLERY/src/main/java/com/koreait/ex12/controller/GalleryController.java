package com.koreait.ex12.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex12.service.GalleryService;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	private GalleryService service;
	
	//@Autowired  // 생성자의 매개변수가 autowired로 적용됨
	public GalleryController(GalleryService service) {
		super();
		this.service = service;
	}
	
	// 목록보기
	@GetMapping("selectGalleryList")
	public String selectGalleryList(Model model) {
		model.addAttribute("list", service.selectGalleryList());
		return "gallery/list";
	}
	
	
	// 등록하러가자
	@GetMapping("insertPage")
	public String insertPage() {
		return "gallery/insert";
	}
	

	// 등록
	@PostMapping(value="insertGallery")
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.insertGallery(multipartRequest, response);
	}
	
	
	// 상세보기
	@GetMapping("selectGalleryByNo")
	public String selectGalleryByNo(@RequestParam Long no, Model model) {
		model.addAttribute("gallery", service.selectGalleryByNo(no));  //gallery를 반환한 값을 "gallery"로 지정
		return "gallery/detail";
	}
	
	
	// 다운로드
	@PostMapping("download")   // origin, path, saved를 받을 매개변수로 request를 사용. 다운로드를 위해 응답이 필요하므로 response 필수
	public void download(HttpServletRequest request, HttpServletResponse response) {
		service.download(request, response);
	}
	
	
	
	// 수정하기
	@PostMapping("updateGallery")
	public void updateGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.updateGallery(multipartRequest, response);
	}
	
	
	// 삭제하기
	@PostMapping("deleteGallery")
	public void deleteGallery(MultipartHttpServletRequest  multipartRequest, HttpServletResponse response) {
		service.deleteGallery(multipartRequest, response);
	}
	
	
	
	
}  // end of gallery
 