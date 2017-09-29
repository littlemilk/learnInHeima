package com.mark.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	static ComboPooledDataSource ds = new ComboPooledDataSource();

	// �������Դ
	public static DataSource getDataSource() {
		return ds;
	}

	// ��ȡ����
	public static Connection getConnection() throws SQLException {
		Connection connection = ds.getConnection();
		return connection;
	}
}
