package com.namoo.mybatis.blog;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.blog.BlogDao;
import com.namoo.mybatis.blog.PostDao;
import com.namoo.mybatis.blog.domain.Blog;
import com.namoo.mybatis.blog.domain.Post;
import com.namoo.mybatis.blog.impl.BlogDaoImpl;
import com.namoo.mybatis.blog.impl.PostDaoImpl;

public class PostDaoTest {

	
	private PostDao postDao;
	private BlogDao blogDao;
	
	@Before
	public void setUp() throws Exception {
		postDao = new PostDaoImpl();
		blogDao = new BlogDaoImpl();
		
	}

	@After
	public void tearDown() throws Exception {
		postDao = null;
		blogDao = null;
	}
	
	@Test
	public void testRegistPost(){
		
		List<Blog> list = blogDao.findAllBlogs();
		assertEquals(2, list.size());
		
		
		Blog blog = blogDao.findBlogByAuthorId("demonpark");
		assertEquals("demonpark", blog.getAuthor().getId());
		assertEquals(1, blog.getId());
		assertEquals(2, blog.getPosts().size());
		
		int beforeSize = blog.getPosts().size();

		Post post = new Post();
		post.setAuthor(blog.getAuthor());
		post.setBlog(blog);
		post.setSubject("jpa");
		post.setContents("ejb3와 jpa");
		
		postDao.registPost(post);
		
		
		blog = blogDao.findBlogByAuthorId("demonpark");
		assertEquals(beforeSize+1, blog.getPosts().size());
		
		assertEquals("jpa", blog.getPosts().get(beforeSize).getSubject());
		//전체 TEST을 위해 insert Post 삭제
		List<Post> posts= postDao.findPostsByBlogId(blog.getId());
		int regPostId = posts.get(posts.size()-1).getId();
		int deleteCount = postDao.deletePost(regPostId);
		assertEquals(1,deleteCount);
		
	}
}
