package com.azhuang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhuang.base.BaseServlet;
import com.azhuang.domain.Category;
import com.azhuang.service.CategoryService;
import com.azhuang.service.impl.CagegoryServiceImpl;
import com.azhuang.utils.JsonUtil;

import net.sf.json.util.JSONUtils;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
       
	public String findAll(HttpServletRequest request,HttpServletResponse response) {
		
		CategoryService cs = new CagegoryServiceImpl();
		try {
			List<Category> cList = cs.findAllCategory();
			
			String list2json = JsonUtil.list2json(cList);
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(list2json);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.写回去findPageBycid&cid="+ this.cid+ "&currPage=1'
		return null;
	}
	

}
