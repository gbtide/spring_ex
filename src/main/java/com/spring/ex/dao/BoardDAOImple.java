package com.spring.ex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ex.vo.BoardVO;

@Repository
public class BoardDAOImple implements IBoardDAO {

	@Autowired
	private SqlSession session;
	
	private static String NAMESPACE = "com.spring.ex.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public BoardVO read(Integer btn) throws Exception {
		return session.selectOne(NAMESPACE + ".read", btn);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(NAMESPACE + ".listAll");
	}

}
