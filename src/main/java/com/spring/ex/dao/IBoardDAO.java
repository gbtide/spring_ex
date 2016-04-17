package com.spring.ex.dao;

import java.util.List;

import com.spring.ex.model.Criteria;
import com.spring.ex.model.SearchCriteria;
import com.spring.ex.vo.BoardVO;

public interface IBoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;

	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;
	
	public int countPaging(Criteria criteria) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria searchCriteria) throws Exception;

	public int listSearchCount(SearchCriteria searchCriteria) throws Exception;
	
}