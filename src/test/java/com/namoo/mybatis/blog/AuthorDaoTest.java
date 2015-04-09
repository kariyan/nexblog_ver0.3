package com.namoo.mybatis.blog;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.blog.domain.Author;
import com.namoo.mybatis.blog.impl.AuthorDaoImpl;


public class AuthorDaoTest {

	private AuthorDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new AuthorDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	
	@Test
	public void testFindAllAuthors(){
		List<Author> authors = dao.findAllAuthors();
		assertEquals(4, authors.size());
		assertEquals("syhan", authors.get(0).getId());
		assertEquals("김현오", authors.get(1).getName());
		assertEquals("jhheo@nextree.co.kr", authors.get(2).getEmail());		
	}
	
	@Test
	public void testFindAuthor(){
		
		Author author = dao.findAuthor("demonpark");
		
		assertEquals("박석재", author.getName());
		assertEquals("demonpark@nextree.co.kr", author.getEmail());
	}
	
	@Test
	public void testFindAuthorByMapper(){
		
		Author author = dao.findAuthorByMapper("demonpark");
		
		assertEquals("박석재", author.getName());
		assertEquals("demonpark@nextree.co.kr", author.getEmail());
	}
	
	@Test
	public void testFindAuthorsByIds() {
		
		//TODO
	}
	
	@Test
	public void testFindAuthorByCondition() {
		
		//TODO
		
	}
	
	@Test
	public void testFindAuthorByConditionByBuilder() {
		
		//TODO

	}	
	
	@Test
	public void testUpdateAuthor() {
		
		//TODO
		
	}
	
	@Test
	public void testDeleteAuthor() {
		
		List<Author> authors = dao.findAllAuthors();
		assertEquals(3,authors.size());
		
		Author insertAuthor = new Author("삽입유저","0000","insertUser@nextree.co.kr");
		insertAuthor.setId("insertUser");
		
		dao.registAuthor(insertAuthor);
		
		assertEquals(4,dao.findAllAuthors().size());
		
		String id = "insertUser";
		dao.deleteAuthor(id);
		
		assertEquals(3,dao.findAllAuthors().size());
	}
			
}
