package com.dh.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dh.home.product.ProductService;
import com.dh.home.product.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public ModelAndView home(ModelAndView mv)throws Exception{
		
		List<ProductVO> list = productService.getAllProduct();
		mv.addObject("list",list);
		log.info("====================");
		log.info("list =>" ,list);
		log.info("====================");
		mv.setViewName("/index");
		
		
		
		return mv;
	}
}
