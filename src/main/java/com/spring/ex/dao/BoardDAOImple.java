package com.spring.ex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ex.model.Criteria;
import com.spring.ex.model.SearchCriteria;
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
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(NAMESPACE + ".read", bno);
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

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(NAMESPACE + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
		return session.selectList(NAMESPACE + ".listCriteria", criteria);
	}

	@Override
	public int countPaging(Criteria criteria) throws Exception {
		return session.selectOne(NAMESPACE + ".countPaging", criteria);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria searchCriteria) throws Exception {
		return session.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int listSearchCount(SearchCriteria searchCriteria) throws Exception {
		return session.selectOne(NAMESPACE + ".listSearchCount", searchCriteria);
	}

}
