package com.dgit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException{		
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:manage");	// DBname 수정
	}
}
