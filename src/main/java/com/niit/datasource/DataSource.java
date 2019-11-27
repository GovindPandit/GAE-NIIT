package com.niit.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource 
{
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			return con;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}
}
