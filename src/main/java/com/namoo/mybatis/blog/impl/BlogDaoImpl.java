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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			return mapper.findBlog(id);

		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<Blog> findBlogByAuthorId(String authorId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

			return mapper.findBlogByAuthorId(authorId);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Blog> findAllBlogs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			return mapper.findAllBlogs();

		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Blog> findBlogsByTitle(String title) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Blog> blog = null;

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			blog = mapper.findBlogsByTitle(title);
		} finally {
			sqlSession.close();
		}
		return blog;
	}
	
	@Override
	public Blog selectBlogWithAuthor(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Blog blog = null;

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			blog = mapper.selectBlogWithAuthor(id);
		} finally {
			sqlSession.close();
		}
		return blog;
	}

	@Override
	public Blog selectBlogWithPost(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Blog blog = null;

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			blog = mapper.selectBlogWithPost(id);
		} finally {
			sqlSession.close();
		}
		return blog;
	}

	@Override
	public void registBlog(Blog blog) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			mapper.registBlog(blog);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int updateBlog(Blog blog) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			return mapper.updateBlog(blog);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int deleteBlog(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			return mapper.deleteBlog(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Blog findBlogByCondition(Blog blog) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Blog createdBlog = null;

		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			createdBlog = mapper.findBlogByCondition(blog);
		} finally {
			sqlSession.close();
		}
		return createdBlog;
	}
}
