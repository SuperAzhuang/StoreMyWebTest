package com.azhuang.service.impl;

import java.util.List;

import com.azhuang.dao.ProductDao;
import com.azhuang.dao.impl.ProductDaoImpl;
import com.azhuang.domain.PageBean;
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

	@Override
	public Product findProductByID(String pid) throws Exception {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDaoImpl();
		Product product = pDao.findProductByID(pid);
		
		
		return product;
	}

	@Override
	public PageBean<Product> findPageBycid(String cid, String currPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		ProductDao pDao = new ProductDaoImpl();
		List<Product> list = pDao.findPageBycid(cid, currPage, pageSize);
		int count = pDao.findTotal(cid);

		Double dCount = Math.ceil(count * 1.0 / pageSize);

		PageBean<Product> pageBean = new PageBean<>(list, Integer.parseInt(currPage), pageSize, count, dCount.intValue());

		return pageBean;
	}

}
