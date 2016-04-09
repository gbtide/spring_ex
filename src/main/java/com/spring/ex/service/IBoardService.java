package com.spring.ex.service;

import java.util.List;

import com.spring.ex.vo.BoardVO;

public interface IBoardService {
	public void regist(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void modify(BoardVO board) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
}
