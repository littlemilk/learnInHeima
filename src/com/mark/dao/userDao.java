package com.mark.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mark.bean.User;
import com.mark.utils.C3P0Utils;

public class userDao {

	public User checkName(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=?";
		return qr.query(sql, new BeanHandler<>(User.class), username);
	}

	public int regist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into user values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode()};
		return qr.update(sql, params);
	}

	public User active(String code) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where code=?";
		
		return qr.query(sql, new BeanHandler<>(User.class), code);
	}

	public void update(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update user set username=?, password=?, name=?, email=?, telephone=?, birthday=?, sex=?, state=?, code=? where uid=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getUid()};
		qr.update(sql, params );
	}

	public User findUserByNameAndPass(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		
		return qr.query(sql, new BeanHandler<>(User.class), username, password);
	}

	

}
