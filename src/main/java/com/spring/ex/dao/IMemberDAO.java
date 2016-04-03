package com.spring.ex.dao;

import com.spring.ex.vo.MemberVO;

public interface IMemberDAO {
	
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
	
}
