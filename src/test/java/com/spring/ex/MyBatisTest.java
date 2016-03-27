package com.spring.ex;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyBatisTest {
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testFactory() {
		System.out.println("=== SqlSessionFactory : " + sqlSessionFactory);
	}
	
	@Test
	public void testSession() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("=== SqlSession : " + sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
