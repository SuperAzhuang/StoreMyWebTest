package com.azhuang.servlet;

import com.azhuang.base.BaseServlet;
import com.azhuang.domain.Category;
import com.azhuang.domain.PageBean;
import com.azhuang.domain.Product;
import com.azhuang.service.CategoryService;
import com.azhuang.service.ProductService;
import com.azhuang.service.impl.CagegoryServiceImpl;
import com.azhuang.service.impl.ProductServiceImpl;
import com.azhuang.utils.CookUtils;
import com.azhuang.utils.JsonUtil;
import com.mchange.v1.util.ArrayUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private int pageSize = 12;

	public String findProductByID(HttpServletRequest request, HttpServletResponse response) {

		String pid = request.getParameter("pid");
		ProductService pService = new ProductServiceImpl();
		try {
			Product product = pService.findProductByID(pid);

			request.setAttribute("product", product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<String> strLists = new LinkedList<String>();
		// LinkedList<String> strLists = null;

		// 设置浏览记录
		Cookie[] cookies = request.getCookies();

		StringBuffer stringBuffer = new StringBuffer();

		Cookie cookie = CookUtils.getCookieByName("ids", cookies);
		if (cookie == null) {
			// 如果cookie为空
			stringBuffer.append(pid + "-");
		} else {
			String value = cookie.getValue();
			String[] split = value.split("-");

			List<String> strLis = (List<String>) Arrays.asList(split);
			// 包含的话移除该对象，并添加到最好一位
			strLists = new LinkedList<String>(strLis);

			if (strLists.contains(pid)) {
				strLists.remove(pid);
			
			} else {
				// 不包含的话判断是否超过5位
				if (strLists.size() > 5) {
					strLists.removeLast();

				}

			}
			strLists.addFirst(pid);
		}
		String[] fruits = new String[strLists.size()];
		String[] array = (String[]) strLists.toArray(fruits);
		for (int i = 0; i < array.length; i++) {
			// pid = pid + "-";
			stringBuffer.append(array[i] + "-");
		}
		String substring =  stringBuffer.toString().substring(0, stringBuffer.toString().length()-1);

		System.out.println("substring = " + substring);
		Cookie c = new Cookie("ids", substring);
		c.setMaxAge(3600);
		c.setPath(request.getContextPath() + "/");
		response.addCookie(c);

		
		
		return "/jsp/product_info.jsp";
	}

	public String findPageBycid(HttpServletRequest request, HttpServletResponse response) {

		String cid = request.getParameter("cid");
		String currPage = request.getParameter("currPage");
		Integer.parseInt(cid);
		ProductService pService = new ProductServiceImpl();

		try {
			PageBean<Product> pBean = pService.findPageBycid(cid, currPage, pageSize);

			System.out.println("pBean = " + pBean);

			request.setAttribute("pb", pBean);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			// String list2json = JsonUtil.list2json(cList);

			response.setContentType("text/html;charset=utf-8");
			// response.getWriter().write(list2json);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.写回去findPageBycid&cid="+ this.cid+ "&currPage=1'
		return "/jsp/product_list.jsp";
	}

}
