package com.namoo.mybatis.blog.mapper;

import java.util.List;

import com.namoo.mybatis.blog.domain.Blog;



public interface BlogMapper {
	
	Blog findBlog(int id);

	Blog findBlogByAuthorId(String authorId);	

	List<Blog> findAllBlogs();

	List<Blog> findBlogsByTitle(String title);
	
	void registBlog(Blog blog);
	
	int updateBlog(Blog blog);

	int deleteBlog(int id);
	
	Blog selectBlogWithAuthor(int id);
	
	Blog selectBlogWithPost(int id);

	Blog findBlogByCondition(Blog blog);

	
	
	
}
