package com.azhuang.service.impl;

import java.util.List;

import com.azhuang.dao.impl.CategoryDaoImpl;
import com.azhuang.domain.Category;
import com.azhuang.service.CategoryService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;



public class CagegoryServiceImpl  implements CategoryService{

	@Override
	public List<Category> findAllCategory() throws Exception {
		// TODO Auto-generated method stub
		

		// 从缓存中进行查询:
		CacheManager cacheManager = CacheManager
				.create(CagegoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		Cache cache = cacheManager.getCache("categoryCache");
		Element element = cache.get("cList");
		
		if (element==null) {
			
			System.out.println("数据库中读取");
			List<Category> cList = new CategoryDaoImpl().findAllCategory();
			cache.put(new Element("cList", cList));
			return cList;
			
		} else {
			System.out.println("缓存中读取");
			List<Category> cList = (List<Category>) element.getObjectValue();
			return cList;
		}
	
	}

}
