package com.dh.home.product;

import java.io.Console;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product/*")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("write")
	public void setProduct()throws Exception{}
	@PostMapping("write")
	public String setProduct(ProductVO productVO, HttpSession session)throws Exception{
		session.getAttribute("member");
		log.info("==============================");
		System.out.println(session.getAttribute("member"));
		log.info("==============================");
		int result = productService.setProduct(productVO);
		return "redirect:../";
	}
}
