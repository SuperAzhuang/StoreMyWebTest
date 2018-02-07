package com.azhuang.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.azhuang.dao.ProductDao;
import com.azhuang.domain.Product;
import com.azhuang.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
	public Product findProductByID(String pid) throws Exception{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid = ? limit 1";
		
		return queryRunner.query(sql, new BeanHandler<>(Product.class),pid);
	}

	@Override
	public List<Product> findPageBycid(String cid, String currPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		int currpa = Integer.parseInt(currPage);
		List<Product> list = queryRunner.query(sql, new BeanListHandler<>(Product.class),cid,(currpa-1)*pageSize,pageSize);
		
		return list;
	}

	@Override
	public int findTotal(String cid) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid = ?";
		Long  query = (Long) queryRunner.query(sql, new ScalarHandler(),cid);
		int intValue = query.intValue();
		return intValue;
	}
}
