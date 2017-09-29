package com.mark.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mark.bean.Order;
import com.mark.bean.OrderItem;
import com.mark.utils.ConnectionManager;

public class orderDao {

	public void saveOrder(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(), order.getName(), order.getTelephone(), order.getUser().getUid()};
		qr.update(ConnectionManager.getConnectionByLocalThread(), sql, params);
	}

	public void save(OrderItem orderItem) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		Object[] params = {orderItem.getItemid(), orderItem.getCount(), orderItem.getSubtotal(), orderItem.getProduct().getPid(), orderItem.getOrder().getOid()};
		qr.update(ConnectionManager.getConnectionByLocalThread(), sql, params);
	}

}
