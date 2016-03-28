package com.spring.ex.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ex.vo.MemberVO;

@Repository
public class MemberDAOImple implements IMemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImple.class);

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.ex.mapper.MemberMapper";
	

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

}
