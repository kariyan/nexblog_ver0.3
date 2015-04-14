package com.namoo.mybatis.blog;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.blog.AuthorDao;
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
		
		List<String> ids = new ArrayList<String>();
		ids.add("demonpark");
		ids.add("kimgisa");
		
		List<Author> authors = dao.findAuthorsByIds(ids);
		assertEquals(2,authors.size());
	}
	
	@Test
	public void testFindAuthorByCondition() {
		
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("id", "demonpark");

		List<Author> authors = dao.findAuthorByCondition(conditionMap);
		
		assertEquals(1,authors.size());
		
		conditionMap.remove("id");
		authors = dao.findAuthorByCondition(conditionMap);
		assertEquals(4,authors.size());
	}
	
	@Test
	public void testFindAuthorByConditionByBuilder() {
		
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("id", "demonpark");
		
		List<Author> authors = dao.findAuthorByConditionByBuilder(conditionMap);
		
		assertEquals(1,authors.size());
		assertEquals("박석재",authors.get(0).getName());
		
		conditionMap.remove("id");
		conditionMap.put("id", "kimgisa");
		conditionMap.put("name", "김현오");
		authors = dao.findAuthorByConditionByBuilder(conditionMap);
		assertEquals("김현오",authors.get(0).getName());	
	}
	
	@Test
	public void testUpdateAuthor() {

		// verify
		String id = "demonPark";
		Author author = dao.findAuthor(id);
		assertEquals("demonpark@nextree.co.kr", author.getEmail());

		// set
		author.setEmail("demonpsj@nextree.co.kr");
		dao.updateAuthor(author);
		
		// execute
		Author updateAuthor = dao.findAuthor(id);
		assertEquals("demonpsj@nextree.co.kr", updateAuthor.getEmail());

		// data reset
		author.setEmail("demonpark@nextree.co.kr");
		dao.updateAuthor(author);
	}
	
	@Test
	public void testDeleteAuthor() {
		
		List<Author> authors = dao.findAllAuthors();
		assertEquals(4,authors.size());
		
		Author insertAuthor = new Author("삽입유저","0000","insertUser@nextree.co.kr");
		insertAuthor.setId("insertUser");
		
		dao.registAuthor(insertAuthor);
		assertEquals(5, dao.findAllAuthors().size());
		
		String id = "insertUser";
		dao.deleteAuthor(id);
		
		assertEquals(4,dao.findAllAuthors().size());
	}
}
