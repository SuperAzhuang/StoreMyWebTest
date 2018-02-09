package com.azhuang.servlet;

import com.azhuang.base.BaseServlet;
import com.azhuang.domain.Cart;
import com.azhuang.domain.CartItem;
import com.azhuang.domain.Product;
import com.azhuang.service.ProductService;
import com.azhuang.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	// cart?method=addPro&pid=${pid}&count=5
	public String addPro(HttpServletRequest request, HttpServletResponse response) {
		// 获取参数
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");

		//
		try {
			// 获取product
			ProductService productService = new ProductServiceImpl();
			Product product = productService.findProductByID(pid);
			System.out.println("pid = " + pid + " count = " + count + "  product = " + product.toString());
			Cart cart = getCart(request);
			cart.add2Cart(new CartItem(product, Integer.parseInt(count)));
			// 放入session域中

			// 重定向
			response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public String clear(HttpServletRequest request, HttpServletResponse response) {

		Cart cart = getCart(request);
		cart.clear();

		try {
			response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Cart getCart(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart == null) {

			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		return cart;
	}

	public String deletFromCartByPid(HttpServletRequest request, HttpServletResponse response) {

		String pid = request.getParameter("pid");
		System.out.println("pid = "+pid);
		
		Cart cart = getCart(request);
		Map<String, CartItem> maps = cart.getMaps();
		
		maps.remove(pid);
		
		try {
			response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
