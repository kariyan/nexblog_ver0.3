package com.namoo.mybatis.blog;

import java.util.List;

import com.namoo.mybatis.blog.domain.Post;


public interface PostDao {
	
	Post findPost(int id);
	
	List<Post> findAllPost();
	
	List<Post> findPostsByBlogId(int id);
	
	List<Post> findPostsByAuthorName(String authorName);
	
	List<Post> findPostsByBlogTitle(String blogTitle);
	
	List<Post> findPostsBySubject(String subject);
	
	List<Post> findPostsByContents(String contents);
	
	int registPost(Post post);
	
	int updatePost(Post post);

	int deletePost(int id);
	
}
