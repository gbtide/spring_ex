package com.spring.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.IBoardDAO;
import com.spring.ex.model.Criteria;
import com.spring.ex.model.SearchCriteria;
import com.spring.ex.vo.BoardVO;

@Service
public class BoardServiceImple implements IBoardService {

	@Autowired
	private IBoardDAO boardDAO;

	@Override
	public void regist(BoardVO vo) throws Exception {
		boardDAO.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return boardDAO.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardDAO.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
		return boardDAO.listCriteria(criteria);
	}

	@Override
	public int listCountCriteria(Criteria criteria) throws Exception {
		return boardDAO.countPaging(criteria);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.listSearch(searchCriteria);
	}

	@Override
	public int listSearchCount(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.listSearchCount(searchCriteria);
	}

}
