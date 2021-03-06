package com.azhuang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.azhuang.base.BaseServlet;
import com.azhuang.domain.User;
import com.azhuang.service.UserService;
import com.azhuang.service.impl.UserServiceImpl;
import com.azhuang.utils.MD5Utils;
import com.azhuang.utils.MyConventer;
import com.azhuang.utils.UUIDUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String registerUi(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/register.jsp";

	}

	public String register(HttpServletRequest request, HttpServletResponse response) {
		// 接收注册参数信息
		User user = new User();

		try {
			// 注册自定义转化器
			ConvertUtils.register(new MyConventer(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			// 用户id
			user.setUid(UUIDUtils.getId());
			// 激活码
			user.setCode(UUIDUtils.getCode());
			user.setPassword(MD5Utils.md5(request.getParameter("password")));

			UserService ueUserService = new UserServiceImpl();
			ueUserService.register(user);

			request.setAttribute("msg", "恭喜您，注册成功，请点击邮箱去激活账户");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/jsp/msg.jsp";

	}

	public String active(HttpServletRequest request, HttpServletResponse response) {
		// 接收激活码拿着激活码去查询用户
		String code = request.getParameter("code");
		UserService userserice = new UserServiceImpl();

		User user = null;
		try {
			user = userserice.getUserByCode(code);
			// 判断用户是否查找到
			if (user == null) {
				request.setAttribute("msg", "未查找到您的用户，请重新注册");

			} else {
				// 设置用户激活成功

				userserice.active(user);
				request.setAttribute("msg", "恭喜您，激活成功");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "/jsp/msg.jsp";
	}

	public String loginUI(HttpServletRequest request, HttpServletResponse response) {
		return "jsp/login.jsp";
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		password = MD5Utils.md5(password);
		System.out.println("username = " + username + "  password = " + password);

		try {
			User user = new UserServiceImpl().login(username, password);
			//
			if (user == null) {

				String msString = "账户密码不对,请重新输入";
				request.setAttribute("msg", msString);
				// response.sendRedirect(request.getContextPath() + "/jsp/msg.jsp");
				return "jsp/login.jsp";

			} else {
				// 设置session
				if (user.getState() != 1) {
					String msString = "您还未点击邮箱激活，请先激活！";
					request.setAttribute("msg", msString);
					return "jsp/login.jsp";
				}
				request.getSession().setAttribute("user", user);
//				 request.getRequestDispatcher("/index").forward(request, response);

				 response.sendRedirect(request.getContextPath()+"/");// /store
				System.out.println("url = " + request.getContextPath() + "/");
				// response.sendRedirect("/");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().invalidate();
		try {
//			request.getRequestDispatcher("/index").forward(request, response);
			 response.sendRedirect(request.getContextPath());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
