package com.niit.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.niit.datasource.DataSource;

public class ValidateUser
{
	public static String validateUsername(String username)
	{
		if(username.length()<4)
		{
			return "Incorrect username";
		}
		else
		{
			try 
			{
				Connection con=DataSource.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from users where username=?");
				ps.setString(1, username);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					return "Username is already exist!!!";
				}
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		return ""; 
	}
	
	public static String validateEmail(String email)
	{
		if(email.length()<10)
		{
			return "incorrect email address";
		}
		return ""; 
	}
	
	public static String validatePassword(String password)
	{
		Pattern p1=Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-@]).{8,16}");
		Matcher m1=p1.matcher(password);
		
		if(!m1.find())
		{
			return "Password is not strong";
		}
		return ""; 
	}
}