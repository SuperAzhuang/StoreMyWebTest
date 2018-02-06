package com.azhuang.dao;

import java.util.List;

import com.azhuang.domain.Product;

public interface ProductDao {

	 List<Product> findAllNewProduct() throws Exception; 
	 List<Product> findAllHotProduct() throws Exception; 
	
}
