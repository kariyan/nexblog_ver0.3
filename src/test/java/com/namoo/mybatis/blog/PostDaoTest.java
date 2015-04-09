package com.namoo.mybatis.blog;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.blog.impl.PostDaoImpl;

public class PostDaoTest {

	
	private PostDao postDao;
	private BlogDao blogDao;
	
	@Before
	public void setUp() throws Exception {
		postDao = new PostDaoImpl();
		
		
	}

	@After
	public void tearDown() throws Exception {
		postDao = null;

	}
	
	@Test
	public void testRegistPost(){
		
		//TODO BlogDao 구현 후 테스트 작성
		
	}
}
