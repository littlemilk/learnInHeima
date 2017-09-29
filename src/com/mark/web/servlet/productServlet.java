package com.mark.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.Page;
import com.mark.bean.Product;
import com.mark.service.productService;

/**
 * Servlet implementation class productServlet
 */
public class productServlet extends baseServlet{
	
	private static final long serialVersionUID = 1L;

	//ͨ���ؼ���������Ʒ
	public void findByKeyword(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String keyword = request.getParameter("keyword");
		productService service = new productService();
			try {
				List<Product> list = service.findByKeyword(keyword);
				if(list != null){	
					Page<Product> pageBean = new Page<>();
					pageBean.setList(list);
					request.setAttribute("pageBean", pageBean);
					request.getRequestDispatcher("/jsp/product_list.jsp").forward(request, response);
				}else{	
					request.setAttribute("msg", "��������Ч�ؼ���");
					try {
						request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	//���ҵ������ֶζ�Ӧ퓔��µ�������Ʒ
	public void findByCategoryIdAndPage(HttpServletRequest request, HttpServletResponse response){
		String cid = request.getParameter("cid");
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		productService productService = new productService();
		try {
			Page<Product> page = productService.findByCategoryIdAndPage(cid, curPage);
			request.setAttribute("pageBean", page);
			request.getRequestDispatcher("/jsp/product_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//����Ʒ����ҳ
	public void findById(HttpServletRequest request, HttpServletResponse response){
		String pid = request.getParameter("pid");
		productService productService = new productService();
		try {
			Product product = productService.findById(pid);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/jsp/product_info.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
