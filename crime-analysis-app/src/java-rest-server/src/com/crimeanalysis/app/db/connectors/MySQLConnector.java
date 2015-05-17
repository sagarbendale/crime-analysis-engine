package com.crimeanalysis.app.db.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

	
	
	public static Connection getConnection() 
	{
		Connection dbConnection=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/CrimeDB?"+ "user=root");
		} 
		
		catch (ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dbConnection;
	}
	
	public static void main(String args[])
	{
		System.out.println(getConnection());
	}
	
	
}
