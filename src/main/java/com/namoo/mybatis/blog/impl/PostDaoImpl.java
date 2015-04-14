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

    public PostDaoImpl() {
        sqlSessionFactory = SqlSessionFactoryProvider.getSqlSessionFactory();
    }

    @Override
    public List<Post> findAllPost() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findAllPost();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int registPost(Post post) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int insertCount = sqlSession.insert("com.namoo.mybatis.blog.mapper.PostMapper.registPost", post);
            sqlSession.commit();
            return insertCount;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Post findPost(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findPost(id);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Post> findPostsByAuthorName(String authorName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
            return postMapper.findPostsByAuthorName(authorName);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Post> findPostsByBlogId(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findPostsByBlogId(id);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Post> findPostsByBlogTitle(String blogTitle) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findPostsByBlogTitle(blogTitle);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Post> findPostsByContents(String contents) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findPostsByContents(contents);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Post> findPostsBySubject(String subject) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.findPostsBySubject(subject);
        } finally {
            sqlSession.close();
        }
    }


    @Override
    public int updatePost(Post post) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);
            return mapper.updatePost(post);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int deletePost(int id) {
        //
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
            int deleteCount = postMapper.deletePost(id);
            sqlSession.commit();
            return deleteCount;
        } finally {
            sqlSession.close();
        }
    }
}
