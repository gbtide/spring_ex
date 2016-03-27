package com.spring.ex;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex";
	private static final String USER = "user";
	private static final String PWD = "q1w2e3";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);

		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(con);
		} catch (Exception e) {
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
