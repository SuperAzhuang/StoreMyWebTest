package com.azhuang.dao;

import java.util.List;

import com.azhuang.domain.Category;

public interface CategoryDao {
 
		List<Category> findAllCategory() throws Exception;
	
}
