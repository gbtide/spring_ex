package com.spring.ex.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ex.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject
	private IBoardDAO dao;
	
//	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 글을 넣습니다.");
		vo.setContent("새로운 글을 넣습니다.");
		vo.setWriter("user00");
		dao.create(vo);
	}
	
//	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
//	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("수정된 글입니다.");
		vo.setContent("수정 테스트");
		dao.update(vo);
	}

//	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}
