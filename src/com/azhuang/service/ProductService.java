package com.azhuang.service;

import java.util.List;

import com.azhuang.domain.PageBean;
import com.azhuang.domain.Product;

public interface ProductService {

	 List<Product> findAllNewProduct() throws Exception; 
	 List<Product> findAllHotProduct() throws Exception; 
	 Product findProductByID(String pid) throws Exception;
	PageBean<Product> findPageBycid(String cid, String currPage, int pageSize) throws Exception;
}
