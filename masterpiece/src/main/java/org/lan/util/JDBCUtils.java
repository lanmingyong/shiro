package org.lan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class JDBCUtils {
	private static Connection conn=null;
	public static Connection getConnection(String driverPackage,String url,String user,String password) {
		try {
			Class.forName(driverPackage);
			conn= DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功！");
		} catch (Exception e) {
			System.out.println("连接数据库失败！");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement() {
		return null;
		
	}
}
