package com.mark.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mark.bean.Order;
import com.mark.bean.OrderItem;
import com.mark.dao.orderDao;
import com.mark.utils.ConnectionManager;

public class orderService {

	public void saveOrder(Order order) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnectionByLocalThread();
			connection.setAutoCommit(false);
			
			orderDao orderDao = new orderDao();
			orderDao.saveOrder(order);
			
			List<OrderItem> orderItems = order.getItems();
			for (OrderItem orderItem : orderItems) {
				orderDao.save(orderItem);
			}
			
			
			connection.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
