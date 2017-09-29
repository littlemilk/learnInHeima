package com.mark.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.Cart;
import com.mark.bean.CartItem;
import com.mark.bean.Product;
import com.mark.service.productService;

/**
 * Servlet implementation class cartServlet
 */
public class cartServlet extends baseServlet{
	//加入购物车
	public void addToCart(HttpServletRequest request, HttpServletResponse response){
		try {
			String pid = request.getParameter("pid");
			int count = Integer.parseInt(request.getParameter("quantity"));
			productService productService = new productService();
			Product product = productService.findById(pid);
			CartItem cartItem = new CartItem();
			
			System.out.println(cartItem.getCount());
			
			cartItem.setCount(count);
			cartItem.setProduct(product);
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart == null){
				cart = new Cart();
			}
			cart.addItem(cartItem, pid);
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath()+ "/jsp/cart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//从购物车删除商品
	public void removeFromCart(HttpServletRequest request, HttpServletResponse response){
		try {
			String pid = request.getParameter("pid");
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart.removeItem(pid);
			response.sendRedirect(request.getContextPath()+ "/jsp/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response){
		try {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart.clearCart();
			response.sendRedirect(request.getContextPath()+ "/jsp/cart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}