package com.mark.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mark.bean.Product;
import com.mark.utils.C3P0Utils;

public class indexDao {

	public List<Product> findHot(int productIsHot) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where is_hot=? and pflag=0 limit 0,9";
		return qr.query(sql, new BeanListHandler<>(Product.class), productIsHot);
	}

	public List<Product> findNew() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product order by pdate desc limit 0,9";
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}

}
