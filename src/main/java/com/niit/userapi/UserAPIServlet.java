package com.niit.userapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.datasource.DataSource;
import com.niit.model.User;

@RestController
public class UserAPIServlet 
{
	@RequestMapping("/getusers")
	public ArrayList<User> getUserData()
	{
		try
		{
			Connection con=DataSource.getConnection();
			ResultSet rs=con.prepareStatement("select * from users").executeQuery();
			
			ArrayList<User> users=new ArrayList<>();
			
			while(rs.next())
			{
				User user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
				users.add(user);
			}
			return users;
		}
		catch (Exception e) 
		{
			return null;
		}
	}
}
