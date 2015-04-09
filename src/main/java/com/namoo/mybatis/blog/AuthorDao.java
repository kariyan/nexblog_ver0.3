package com.namoo.mybatis.blog;

import java.util.List;
import java.util.Map;

import com.namoo.mybatis.blog.domain.Author;


public interface AuthorDao {

	Author findAuthor(String id);
	
	Author findAuthorByMapper(String id);

	List<Author> findAllAuthors();	
	
	List<Author> findAllAuthorsByMapper();

	List<Author> findAuthorsByName(String name);

	void registAuthor(Author author);

	int updateAuthor(Author author);

	void deleteAuthor(String id);
	
	List<Author> findAuthorsByIds(List<String> ids);
	
	List<Author> findAuthorByCondition(Map<String,String> conditionMap);
	
	List<Author> findAuthorByConditionByBuilder(Map<String,String> conditionMap);	
}
