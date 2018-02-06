package com.azhuang.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhuang.base.BaseServlet;
import com.azhuang.domain.Category;
import com.azhuang.service.impl.CagegoryServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 这边查询一些商品，分类数据，并添加到域对象
		// System.out.println("IndexServlet");
		List<Category> list = new CagegoryServiceImpl().findAllCategory();
			
	for (int i = 0; i < list.size(); i++) {
	
		System.out.println("list = " +list.get(i));
		
	}
		
		request.getSession().setAttribute("cList", list);

		return "/jsp/index.jsp";
	}

}
