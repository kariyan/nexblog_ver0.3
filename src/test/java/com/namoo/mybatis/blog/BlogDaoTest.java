package com.namoo.mybatis.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.blog.BlogDao;
import com.namoo.mybatis.blog.domain.Author;
import com.namoo.mybatis.blog.domain.Blog;
import com.namoo.mybatis.blog.impl.BlogDaoImpl;

public class BlogDaoTest {

	private BlogDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new BlogDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testFindAllBlogs() {
		List<Blog> blogs = dao.findAllBlogs();
		assertEquals(2, blogs.size());
	}

	@Test
	public void testFindBlog() {
		Blog blog = dao.findBlog(1);

		assertEquals("하늘바람별", blog.getTitle());
		assertEquals("demonpark", blog.getAuthor().getId());

		assertNotNull(blog.getPosts());
		assertEquals(2, blog.getPosts().size());

		assertEquals("mybatis", blog.getPosts().get(0).getSubject());
		assertEquals("mybatis의 이해와 적용", blog.getPosts().get(0).getContents());
		assertEquals("mybatis3", blog.getPosts().get(1).getSubject());
		assertEquals("mybatis 3.0 무작정 따라하기", blog.getPosts().get(1).getContents());
	}

	@Test
	public void testFindBlogsByTitle() {

		List<Blog> blogs = dao.findBlogsByTitle("하늘");

		assertEquals(1, blogs.size());
		assertEquals("demonpark", blogs.get(0).getAuthor().getId());
	}

	@Test
	public void testFindBlogsAuthorId() {
		Blog blog = dao.findBlogByAuthorId("demonpark");

		assertEquals(1, blog.getId());
		assertEquals("하늘바람별", blog.getTitle());

	}
	
	@Test
	public void testSelectBlogWithAuthor() {
		Blog blog = dao.selectBlogWithAuthor(1);
		
		assertEquals("박석재",blog.getAuthor().getName());
	}
	
	@Test
	public void testSelectBlogWithPost() {
		Blog blog = dao.selectBlogWithPost(1);
		
		assertNotNull(blog.getPosts());
		assertEquals(2, blog.getPosts().size());

		assertEquals("mybatis", blog.getPosts().get(0).getSubject());
		assertEquals("mybatis의 이해와 적용", blog.getPosts().get(0).getContents());
		assertEquals("mybatis3", blog.getPosts().get(1).getSubject());
		assertEquals("mybatis 3.0 무작정 따라하기", blog.getPosts().get(1).getContents());
	}
	
	@Test
	public void testFindBlogByConditionByIf() {
		Blog conditionBlog = new Blog();
		//conditionBlog.setTitle("하늘");
		Author author = new Author("박석재","","");
		author.setId("demonpark");
		conditionBlog.setAuthor(author);
		Blog blog = dao.findBlogByCondition(conditionBlog);
		
		assertEquals("mybatis", blog.getPosts().get(0).getSubject());
		assertEquals("mybatis의 이해와 적용", blog.getPosts().get(0).getContents());
	}

}
