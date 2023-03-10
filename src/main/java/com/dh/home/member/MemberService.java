package com.dh.home.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.home.order.OrderVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	public List<MemberVO> getMembers()throws Exception{
		return memberMapper.getMembers();
	}
	
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
