package com.mark.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mark.bean.Product;
import com.mark.utils.C3P0Utils;

public class productDao {

	//����ָ��ID��Ʒ
	public Product findById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		return qr.query(sql, new BeanHandler<>(Product.class), pid);
	}
	//����ָ����͵�������Ʒ
	public List<Product> findByCid(int a, int b, String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where cid=? limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Product.class), cid,a,b);
	}
	//Ӌ��ָ����͵�������Ʒ�Ĕ���
	public int countByCid(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "SELECT count(*) from product where cid = ?";
		Long num = (Long) qr.query(sql, new ScalarHandler(), cid);
		return num.intValue();
	}
	//�ؼ���ģ����ѯ
	public List<Product> findByKeyword(String keyword) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pname like ?";
		String param = "%" + keyword + "%";
		return qr.query(sql, new BeanListHandler<>(Product.class), param);
	}

}
