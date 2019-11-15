package com.niit.daoimpl;

import java.util.List;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOImpl implements UserDAO
{

	@Override
	public boolean addUser(User user) 
	{
		return false;
	}

	@Override
	public boolean deleteUser(User user) 
	{
		return false;
	}

	@Override
	public boolean updateUser(User user) 
	{
		return false;
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
