package com.azhuang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhuang.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String index(HttpServletRequest request,HttpServletResponse response) {
//		这边查询一些商品，分类数据，并添加到域对象
		System.out.println("IndexServlet");
		
		return "/jsp/index.jsp";
	}

}
