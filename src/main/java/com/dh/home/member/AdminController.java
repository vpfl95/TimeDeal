package com.dh.home.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("product")
	public void getPorducts()throws Exception{
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
