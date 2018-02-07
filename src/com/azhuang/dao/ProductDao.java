package com.azhuang.dao;

import java.util.List;

import com.azhuang.domain.Product;

public interface ProductDao {

	List<Product> findAllNewProduct() throws Exception;

	List<Product> findAllHotProduct() throws Exception;

	Product findProductByID(String pid) throws Exception;

	List<Product> findPageBycid(String cid, String currPage, int pageSize) throws Exception;

	int findTotal(String cid) throws Exception;

}
