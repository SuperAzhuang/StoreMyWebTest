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
import com.azhuang.domain.Product;
import com.azhuang.service.impl.CagegoryServiceImpl;
import com.azhuang.service.impl.ProductServiceImpl;

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
		List<Product> hList = new ProductServiceImpl().findAllHotProduct();
		List<Product> nList = new ProductServiceImpl().findAllNewProduct();

		for (int i = 0; i < hList.size(); i++) {

//			System.out.println("hList = " + hList.get(i));

		}
		for (int i = 0; i < nList.size(); i++) {

//			System.out.println("nList = " + nList.get(i));

		}

		request.getSession().setAttribute("hList", hList);
		request.getSession().setAttribute("nList", nList);

		return "/jsp/index.jsp";
	}

}
