package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.datasource.DataSource;
import com.niit.email.Email;
import com.niit.model.User;
//
@WebServlet("/LoginController")
public class LoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user=new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();
			
			HttpSession hs=request.getSession();
			if(rs.next())
			{
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				hs.setAttribute("user", user);
				hs.setAttribute("msg", "Welcome "+user.getUsername());
				hs.setAttribute("type", "success");
				hs.setAttribute("pagename", "displayproducts.jsp");
			}
			else
			{
				hs.setAttribute("msg", "Incorrect username or password!!!");
				hs.setAttribute("type", "error");
				hs.setAttribute("pagename", "login.jsp");
			}
			response.sendRedirect("popup.jsp");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
