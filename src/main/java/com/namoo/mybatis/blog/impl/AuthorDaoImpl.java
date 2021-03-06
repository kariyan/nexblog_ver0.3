package com.namoo.mybatis.blog.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.namoo.mybatis.blog.AuthorDao;
import com.namoo.mybatis.blog.domain.Author;
import com.namoo.mybatis.blog.mapper.AuthorMapper;


public class AuthorDaoImpl implements AuthorDao {

	private static Log log = LogFactory.getLog(AuthorDaoImpl.class);
	
	private SqlSessionFactory sqlSessionFactory;
	
	public AuthorDaoImpl(){
		sqlSessionFactory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	

	@Override
	public List<Author> findAllAuthors() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try{
			authors = sqlSession.selectList("com.namoo.mybatis.blog.mapper.AuthorMapper.findAllAuthors");
			log.debug("authors: " + authors);
		} finally {
			sqlSession.close();
		}
		return authors;
	}
	
	@Override
	public List<Author> findAllAuthorsByMapper() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try{
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			authors = mapper.findAllAuthors();
		} finally {
			sqlSession.close();
		}
		return authors;
	}	

	@Override
	public Author findAuthor(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Author author = null;
		try{
			author = sqlSession.selectOne("com.namoo.mybatis.blog.mapper.AuthorMapper.findAuthor", id);
			log.debug("author: " + author);
		} finally {
			sqlSession.close();
		}
		return author;
	}
	
	@Override
	public Author findAuthorByMapper(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Author author = null;
		try{
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			author = mapper.findAuthor(id);
		} finally {
			sqlSession.close();
		}
		return author;
	}

	@Override
	public List<Author> findAuthorsByIds(List<String> ids) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			authors = mapper.findAuthorsByIds(ids);
		} finally {
			sqlSession.close();
		}
		return authors;
	}
	
	@Override
	public List<Author> findAuthorByCondition(Map<String, String> conditionMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			authors = mapper.findAuthorByCondition(conditionMap);
		} finally {
			sqlSession.close();
		}
		return authors;
	}
	
	@Override
	public List<Author> findAuthorByConditionByBuilder(Map<String, String> conditionMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			authors = mapper.findAuthorByConditionByBuilder(conditionMap);
		} finally {
			sqlSession.close();
		}
		return authors;
	}
	
	@Override
	public List<Author> findAuthorsByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Author> authors = null;
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			authors = mapper.findAuthorsByName(name);
		} finally {
			sqlSession.close();
		}
		return authors;
	}

	@Override
	public void registAuthor(Author author) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			mapper.registAuthor(author);
			sqlSession.commit();
		}finally{
			sqlSession.clearCache();
			sqlSession.close();
		}		
	}

	@Override
	public int updateAuthor(Author author) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			cnt = mapper.updateAuthor(author);
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public void deleteAuthor(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
			mapper.deleteAuthor(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}		
}
