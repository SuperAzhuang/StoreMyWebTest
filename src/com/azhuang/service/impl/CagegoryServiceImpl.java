package com.azhuang.service.impl;

import java.util.List;

import com.azhuang.dao.impl.CategoryDaoImpl;
import com.azhuang.domain.Category;
import com.azhuang.service.CategoryService;

public class CagegoryServiceImpl  implements CategoryService{

	@Override
	public List<Category> findAllCategory() throws Exception {
		// TODO Auto-generated method stub
		return new CategoryDaoImpl().findAllCategory();
	}

}
