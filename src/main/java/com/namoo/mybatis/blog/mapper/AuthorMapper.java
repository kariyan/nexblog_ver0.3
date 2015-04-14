package com.namoo.mybatis.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.namoo.mybatis.blog.domain.Author;
import org.apache.ibatis.annotations.Select;


public interface AuthorMapper {

	Author findAuthor(String id);

	List<Author> findAllAuthors();
	
	List<Author> findAuthorsByIds(List<String> ids);
	
	List<Author> findAuthorByCondition(Map<String,String> conditionMap);

	@Select("SELECT password, name, email FROM author_tb WHERE id = #{id}")
	List<Author> findAuthorByConditionByBuilder(Map<String,String> conditionMap);
	
	List<Author> findAuthorsByName(String name);

	void registAuthor(Author author);

	int updateAuthor(Author author);

	void deleteAuthor(@Param("id")String id);
}
