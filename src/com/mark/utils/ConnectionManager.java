package com.mark.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionManager {

	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

	public static Connection getConnectionByLocalThread() throws SQLException {
		Connection connection = t1.get();

		if (connection == null) {
			connection = C3P0Utils.getConnection();
			t1.set(connection);
		}
		return connection;
	}

	public static void startTransaction() throws SQLException {
		Connection connection = getConnectionByLocalThread();
		connection.setAutoCommit(false);
	}

	public static void commit() throws SQLException {
		Connection connection = getConnectionByLocalThread();
		connection.commit();
	}

	public static void rollback() throws SQLException {
		Connection connection = getConnectionByLocalThread();
		connection.rollback();
	}
	
	
	public static void close() throws SQLException {
		Connection connection = getConnectionByLocalThread();
		connection.close();
	}

}
