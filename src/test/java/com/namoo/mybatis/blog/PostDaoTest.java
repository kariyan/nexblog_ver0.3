package com.namoo.mybatis.blog;


import com.namoo.mybatis.blog.domain.Blog;
import com.namoo.mybatis.blog.domain.Post;
import com.namoo.mybatis.blog.impl.BlogDaoImpl;
import com.namoo.mybatis.blog.impl.PostDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
    public void testFindPost() {
        Post post = postDao.findPost(1);
        assertEquals("mybatis", post.getSubject());
    }

    @Test
    public void findAllPost() {
        List<Post> posts = postDao.findAllPost();
        assertEquals(3, posts.size());
    }

    @Test
    public void testRegistPost() {

        List<Blog> list = blogDao.findAllBlogs();
        assertEquals(2, list.size());


        list = blogDao.findBlogByAuthorId("demonpark");
        Blog blog = list.get(0);
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

        list = blogDao.findBlogByAuthorId("demonpark");
        blog = list.get(0);
        assertEquals(beforeSize + 1, blog.getPosts().size());

        assertEquals("jpa", blog.getPosts().get(beforeSize).getSubject());
        //전체 TEST을 위해 insert Post 삭제
        List<Post> posts = postDao.findPostsByBlogId(blog.getId());
        int regPostId = posts.get(posts.size() - 1).getId();
        int deleteCount = postDao.deletePost(regPostId);
        assertEquals(1, deleteCount);

    }
}
