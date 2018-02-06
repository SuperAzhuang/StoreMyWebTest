package com.azhuang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.azhuang.dao.CategoryDao;
import com.azhuang.domain.Category;
import com.azhuang.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAllCategory() throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		
		List<Category> query = queryRunner.query(sql, new BeanListHandler<>(Category.class));
		
		return query;
	}

}
