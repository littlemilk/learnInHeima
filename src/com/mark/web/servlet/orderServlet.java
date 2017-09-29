package com.mark.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mark.bean.Cart;
import com.mark.bean.CartItem;
import com.mark.bean.Order;
import com.mark.bean.OrderItem;
import com.mark.bean.User;
import com.mark.constant.Constant;
import com.mark.service.orderService;
import com.mark.utils.UUIDUtils;

/**
 * Servlet implementation class orderServlet
 */
public class orderServlet extends baseServlet{
	
	public void showOrder(HttpServletRequest request, HttpServletResponse response){
		
		try {
			User user = (User) request.getSession().getAttribute("user");
			if(user == null){
				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
				return;
			}
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			Order order = new Order();
			order.setOid(UUIDUtils.getId());
			order.setUser(user);
			order.setTotal(cart.getSumTotal());
			order.setOrdertime(new Date());
			order.setState(Constant.IS_NOT_PAY);
			List<OrderItem> items = null;
			Collection<CartItem> cartItem = cart.getValues();
			for (CartItem value : cartItem) {
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(value.getCount());
				orderItem.setItemid(UUIDUtils.getId());
				orderItem.setOrder(order);
				orderItem.setProduct(value.getProduct());
				orderItem.setSubtotal(value.getTotal());
				items.add(orderItem);
			}
			order.setItems(items);
			
			cart.clearCart();
			
			orderService orderService = new orderService();
			orderService.saveOrder(order);
			
			request.setAttribute("order", order);
			request.getRequestDispatcher("/jsp/order_info.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
