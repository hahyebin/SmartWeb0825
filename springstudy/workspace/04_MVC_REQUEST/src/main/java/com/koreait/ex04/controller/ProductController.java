package com.koreait.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex04.domain.Product;

@Controller
@RequestMapping("product")
public class ProductController {

		    // <form action="product/v1.do" method="get"></form>
			//     <input name="mName"><input name="price">
	
		@GetMapping("v1.do")
		public String v1(HttpServletRequest request, Model model) {
			String mName = request.getParameter("mName");
			int price = Integer.parseInt(request.getParameter("price"));
			
			
//			Product product = new Product.Builder()
//					.setmName(mName)
//					.setPrice(price)
//					.build();
			
			model.addAttribute("product", new Product.Builder()
										.setmName(mName)
										.setPrice(price)
										.build() );
			
			return "product/productDetail";
		}
		
		
		
		// 		<form action="product/v2.do" method="post">
		@PostMapping("v2.do")
		public String v2(@RequestParam(value="mName") String mName,
				         @RequestParam(value="price") int price, Model model) {
			
			model.addAttribute("product", new Product.Builder().setmName(mName).setPrice(price).build());
			
			return "product/productDetail";
		}
		
	
}
