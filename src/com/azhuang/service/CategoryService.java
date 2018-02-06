package com.azhuang.service;

import java.util.List;

import com.azhuang.domain.Category;

public interface CategoryService {
	List<Category> findAllCategory() throws Exception;
}
