package com.dh.home.member;

import java.io.Console;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("login")
	public void getLogin()throws Exception{
	}
	@PostMapping("login")
	public String getLogin(HttpSession session, MemberVO memberVO)throws Exception{
		memberVO = memberService.getLogin(memberVO);
		log.info("========================================");
		System.out.println(memberVO.getRole().getRoleName());
		log.info("========================================");
		session.setAttribute("member", memberVO);
		if(memberVO.getRole().getRoleName().equals("MEMBER")) {
			session.setAttribute("memberRole", memberVO.getRole());			
		}else {
			session.setAttribute("adminRole", memberVO.getRole());			
		}
		return "redirect:../";
	}
	
	@GetMapping("join")
	public void setJoin()throws Exception{
	}
	@PostMapping("join")
	public ModelAndView setJoin(MemberVO memberVO, ModelAndView mv)throws Exception{
		int result = memberService.setJoin(memberVO);

		mv.setViewName("redirect:login");
		return mv;
	}

}
