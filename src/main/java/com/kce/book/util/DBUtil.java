package com.kce.book.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="admin";
		Connection connection=DriverManager.getConnection(url,user,pass);
		return connection;
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}