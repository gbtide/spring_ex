package com.spring.ex.dao;

import com.spring.ex.vo.MemberVO;

public interface IMemberDAO {
	public String getTime();
	public void insertMember(MemberVO vo);
}
