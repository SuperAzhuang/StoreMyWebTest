package com.azhuang.service.impl;

import java.util.List;

import com.azhuang.dao.ProductDao;
import com.azhuang.dao.impl.ProductDaoImpl;
import com.azhuang.domain.Product;
import com.azhuang.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findAllNewProduct() throws Exception {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDaoImpl();
		List<Product> list = pDao.findAllNewProduct();

		return list;
	}

	@Override
	public List<Product> findAllHotProduct() throws Exception {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDaoImpl();
		List<Product> list = pDao.findAllHotProduct();
		return list;
	}

}
