package com.mark.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.Product;
import com.mark.constant.Constant;
import com.mark.service.indexService;

/**
 * Servlet implementation class indexServlet
 */
public class indexServlet extends baseServlet{
	
	private static final long serialVersionUID = 1L;

	public void findHotAndNew(HttpServletRequest request, HttpServletResponse response){
		indexService indexService = new indexService();
		int productIsHot = Constant.PRODUCT_IS_HOT;
		List<Product> hotList;
		List<Product> newList;
		try {
			hotList = indexService.findHot(productIsHot);
			newList = indexService.findNew();
			request.setAttribute("hotList", hotList);
			request.setAttribute("newList", newList);
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
