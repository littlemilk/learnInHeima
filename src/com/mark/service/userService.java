package com.mark.service;

import java.sql.SQLException;

import com.mark.bean.User;
import com.mark.dao.userDao;

public class userService {
	//用户名查重
	public String checkName(String username) throws SQLException {
		userDao dao = new userDao();
		User user = dao.checkName(username);
		if(user != null){
			return "用户名已存在！";
		}else{
			return "";
		}
	}
	//用户注册
	public int regist(User user) throws SQLException {
		userDao dao = new userDao();
		int num = dao.regist(user);
		return num;
	}
	//用户激活
	public User active(String code) throws SQLException {
		userDao dao = new userDao();
		User user = dao.active(code);
		return user;
	}
	//激活后更新用户信息
	public void update(User user) throws SQLException {
		userDao dao = new userDao();
		dao.update(user);
		
	}
	//登录
	public User findUserByNameAndPass(String username, String password) throws SQLException {
		userDao dao = new userDao();
		return dao.findUserByNameAndPass(username, password);
	}

}
