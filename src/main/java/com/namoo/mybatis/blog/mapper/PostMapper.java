package com.namoo.mybatis.blog.mapper;

import java.util.List;

import com.namoo.mybatis.blog.domain.Post;


public interface PostMapper {
	
	//TODO Annotation Select
	Post findPost(int id);
	
	List<Post> findAllPost();

	
	List<Post> findPostsByBlogId(int id);
	
	List<Post> findPostsByAuthorName(String authorName);
	
	List<Post> findPostsByBlogTitle(String blogTitle);
	
	List<Post> findPostsBySubject(String subject);
	
	List<Post> findPostsByContents(String contents);
	
	void registPost(Post post);
	
	int updatePost(Post post);

	//TODO Annotation delete
	int deletePost(int id);
	
}
