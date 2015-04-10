package com.namoo.mybatis.blog.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.namoo.mybatis.blog.BlogDao;
import com.namoo.mybatis.blog.domain.Blog;
import com.namoo.mybatis.blog.mapper.BlogMapper;

public class BlogDaoImpl implements BlogDao {

	private static Log log = LogFactory.getLog(BlogDaoImpl.class);
	
	private SqlSessionFactory sqlSessionFactory;

	public BlogDaoImpl() {
		sqlSessionFactory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Blog findBlog(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Blog findBlogByAuthorId(String authorId){
		// TODO 매퍼객체를 생성하여 Sql매핑문 호출하기
		return null;
	}
	
	
	@Override
	public List<Blog> findAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> findBlogsByTitle(String title) {
		// TODO session의 메소드를 사용하여 Sql매핑문 호출하기
		return null;
	}
	
	@Override
	public Blog selectBlogWithAuthor(int id) {
		// TODO Nested Result
		return null;
	}

	@Override
	public Blog selectBlogWithPost(int id) {
		// TODO Nested Result
		return null;
	}

	@Override
	public void registBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBlog(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Blog findBlogByCondition(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

}
