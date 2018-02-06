package com.azhuang.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.azhuang.dao.ProductDao;
import com.azhuang.domain.Product;
import com.azhuang.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAllNewProduct() throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit 9";

		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public List<Product> findAllHotProduct() throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = 1 limit 9";

		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

}
