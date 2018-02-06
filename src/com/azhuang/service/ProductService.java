package com.azhuang.service;

import java.util.List;

import com.azhuang.domain.Product;

public interface ProductService {

	 List<Product> findAllNewProduct() throws Exception; 
	 List<Product> findAllHotProduct() throws Exception; 
	
}
