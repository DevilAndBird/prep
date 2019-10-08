package com.csair.cbs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;
import org.w3c.dom.Document;

public class JDBC_Connection {
	
	static Document document;
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		ds.setMaxIdle(3000);
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setMaxActive(20);
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("11");
		ds.setPassword("11");
		ds.setMaxWait(12000);
		ds.setDefaultAutoCommit(true);
		ds.setRemoveAbandoned(true);
		ds.setRemoveAbandonedTimeout(60*5);
	}
		
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("%% 无法获取数据库连接 !!! %%");
			e.printStackTrace();
		}
		return con;
	}
		
	public static void release(ResultSet rs, Statement stmt, Connection con) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
