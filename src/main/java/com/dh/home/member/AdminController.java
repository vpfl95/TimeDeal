package com.dh.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dh.home.product.ProductService;
import com.dh.home.product.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin/*")
@Slf4j
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("product")
	public ModelAndView getPorducts(HttpSession session, ModelAndView mv)throws Exception{
		String id = (String)session.getAttribute("member");
		List<ProductVO> list = productService.getProduct(id);
		mv.addObject("list",list);
		mv.setViewName("admin/product");
		return mv;
	}
	
	@GetMapping("members")
	public ModelAndView getMembers(ModelAndView mv)throws Exception{
		List<MemberVO> list = memberService.getMembers();
		
		System.out.println(list);
		
		mv.addObject("list",list);
		mv.setViewName("admin/members");
		return mv;
	}
}
