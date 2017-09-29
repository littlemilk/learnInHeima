package com.mark.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.Category;
import com.mark.service.catecoryService;
import com.mark.utils.JsonUtils;

import net.sf.json.util.JSONUtils;

/**
 * Servlet implementation class categoryServlet
 */
public class categoryServlet extends baseServlet{
	
	public void findCatecory(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		catecoryService service = new catecoryService();
		try {
			String data = service.findCategory();
			response.getWriter().println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
