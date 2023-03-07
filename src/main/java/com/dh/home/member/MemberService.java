package com.dh.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public int setJoin(MemberVO memberVO)throws Exception{
		int result = memberMapper.setJoin(memberVO);
		if(result==1) {
			result = memberMapper.setRole(memberVO);
		}
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
}
