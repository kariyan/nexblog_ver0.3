package com.namoo.mybatis.blog.impl;

import java.util.List;








import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.namoo.mybatis.blog.PostDao;
import com.namoo.mybatis.blog.domain.Post;
import com.namoo.mybatis.blog.mapper.PostMapper;

public class PostDaoImpl implements PostDao {

	private static Log log = LogFactory.getLog(PostDaoImpl.class);
	
	private SqlSessionFactory sqlSessionFactory;
	
	public PostDaoImpl(){
		sqlSessionFactory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}	

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registPost(Post post) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			int insertCount = sqlSession.insert("com.namoo.mybatis.blog.mapper.PostMapper.registPost", post);
			sqlSession.commit();
			
			return insertCount;
		} finally{
			sqlSession.close();
		}
	}
	
	@Override
	public Post findPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Post> findPostsByBlogId(int id) {
		// TODO Auto-generated method stub
		return null;	
	}
	
	@Override
	public List<Post> findPostsByBlogTitle(String blogTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsByContents(String contents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostsBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deletePost(int id) {
		// 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
			int deleteCount = postMapper.deletePost(id);
			sqlSession.commit();
			return deleteCount; 		
		} finally {
			sqlSession.close();
		}
	}


}
