package com.namoo.mybatis.blog.mapper;

import java.util.List;

import com.namoo.mybatis.blog.domain.Post;
import org.apache.ibatis.annotations.Select;


public interface PostMapper {
	
	@Select("SELECT id, subject, contents FROM post_tb WHERE id = #{id}")
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
