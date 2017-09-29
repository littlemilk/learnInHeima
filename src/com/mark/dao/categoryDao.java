package com.mark.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mark.bean.Category;
import com.mark.utils.C3P0Utils;

public class categoryDao {

	public List<Category> findCategoryFromBase() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<>(Category.class));
	}


}
