package com.spring.ex.dao;

import java.util.List;

import com.spring.ex.vo.BoardVO;

public interface IBoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer btn) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;

}
