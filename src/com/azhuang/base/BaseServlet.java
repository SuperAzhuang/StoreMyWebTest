package com.azhuang.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.toolkit.url.Uri;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(request, response);
		// 获取calss字节码
		@SuppressWarnings("rawtypes")
		Class class1 = this.getClass();

		// 获取method参数
		System.out.println("baseservlet");
		String methodPar = request.getParameter("method");
		// 如果没有指定的method方法路径
		if (methodPar == null) {
			methodPar = "index";
		}
		//拿着methodPar获取方法对象
		try {
			Method methodUrl = class1.getMethod(methodPar, HttpServletRequest.class,HttpServletResponse.class);
//			让方法执行,返回的是一个转发路劲
			
			String invokeUrl = (String) methodUrl.invoke(this, request,response);
			
			// 5.判断s是否为空
			if(invokeUrl!=null){
				System.out.println("invokeUrl="+invokeUrl);
				request.getRequestDispatcher(invokeUrl).forward(request, response);
//				response.sendRedirect(invokeUrl);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			request.getSession().setAttribute("mymsg", "程序奔溃啦-------------");
//			request.getRequestDispatcher("/jsp/mymsg.jsp").forward(request, response);
		}
		

	}
}
