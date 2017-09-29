package com.mark.service;

import java.sql.SQLException;

import com.mark.bean.User;
import com.mark.dao.userDao;

public class userService {
	//�û�������
	public String checkName(String username) throws SQLException {
		userDao dao = new userDao();
		User user = dao.checkName(username);
		if(user != null){
			return "�û����Ѵ��ڣ�";
		}else{
			return "";
		}
	}
	//�û�ע��
	public int regist(User user) throws SQLException {
		userDao dao = new userDao();
		int num = dao.regist(user);
		return num;
	}
	//�û�����
	public User active(String code) throws SQLException {
		userDao dao = new userDao();
		User user = dao.active(code);
		return user;
	}
	//���������û���Ϣ
	public void update(User user) throws SQLException {
		userDao dao = new userDao();
		dao.update(user);
		
	}
	//��¼
	public User findUserByNameAndPass(String username, String password) throws SQLException {
		userDao dao = new userDao();
		return dao.findUserByNameAndPass(username, password);
	}

}
