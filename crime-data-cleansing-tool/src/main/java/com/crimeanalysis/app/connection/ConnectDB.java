package com.crimeanalysis.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	Connection conn = null;

	public Connection connect() {
		final String DB_URL = "jdbc:mysql://localhost/crimeDB";

		final String USER = "root";
		final String PASS = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
