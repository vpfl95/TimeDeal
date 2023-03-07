package com.dh.home.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public List<MemberVO> getMembers()throws Exception;
	public int setRole(MemberVO memberVO)throws Exception;
	public int setJoin(MemberVO memberVO)throws Exception;
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
}
