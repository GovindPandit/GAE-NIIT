package com.niit.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOImpl implements UserDAO
{
	
	@Override
	public boolean addUser(User user) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			PreparedStatement ps=con.prepareStatement("insert into users (username,email,password,role) values(?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, "user");
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) 
	{
		return false;
	}

	@Override
	public boolean updateUser(User user) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			PreparedStatement ps=con.prepareStatement("update users set username=?,email=? where userid=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getUserid());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}

	}

	@Override
	public List<User> displayUsers()
	{
		return null;
	}

	@Override
	public User displayUserByUsername(String username) 
	{
		return null;
	}

	@Override
	public User displayUserById(int userid) 
	{
		return null;
	}

}
