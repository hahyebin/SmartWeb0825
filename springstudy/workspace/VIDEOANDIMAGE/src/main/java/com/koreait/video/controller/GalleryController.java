package com.koreait.video.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.video.service.GalleryService;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	private GalleryService service;
	
	//@Autowired  // 생성자의 매개변수가 autowired로 적용됨
	public GalleryController(GalleryService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("selectGalleryList")
	public String selectGalleryList(Model model) {
		model.addAttribute("list", service.selectGalleryList());
		return "gallery/list";
	}
	
	@GetMapping("insertPage")
	public String insertPage() {
		return "gallery/insert";
	}

	
	@PostMapping(value="insertGallery")
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.insertGallery(multipartRequest, response);
	}
	
	
	@GetMapping("selectGalleryByNo")
	public String selectGalleryByNo(@RequestParam Long no, Model model) {
		model.addAttribute("gallery", service.selectGalleryByNo(no));  //gallery를 반환한 값을 "gallery"로 지정
		return "gallery/detail";
	}
	
	
	
	
	
	
	
	
	
	
	
}  // end of gallery
 