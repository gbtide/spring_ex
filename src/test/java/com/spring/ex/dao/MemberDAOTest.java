package com.spring.ex.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.ex.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Autowired
	private IMemberDAO memberDAO;
	
	@BeforeClass
	public static void callBeforeClass() {
		System.out.println("#. called BeforeClass");
	}
	
	@Before
	public void callBefore() {
		System.out.println("#. called Before");
	}
	
	@Test
	public void testTime() throws Exception {
		System.out.println("=== memberDAO.getTime() : " + memberDAO.getTime());
	}
	
//	@Test
	public void testInsertMember() throws Exception {
		System.out.println("=== insert some member : ");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		
		memberDAO.insertMember(vo);
	}
}
