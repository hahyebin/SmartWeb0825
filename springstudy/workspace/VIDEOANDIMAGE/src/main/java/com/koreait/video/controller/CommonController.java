package com.koreait.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

		@GetMapping("/")
		public String index() {
			return "index";
		}
}
