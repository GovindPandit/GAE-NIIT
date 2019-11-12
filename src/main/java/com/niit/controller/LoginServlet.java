package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.email.Email;
import com.niit.model.User;

@WebServlet("/LoginController")
public class LoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user=new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		if(user.getUsername().equals("Ankit123") && user.getPassword().equals("pass@123"))
		{
			try
			{
				Email email=new Email("ankitjain1002@gmail.com", "Welcome!!!!", "Test Email!!!!");
				email.sendEmail();
				response.sendRedirect("index.jsp");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Incorrect username or password!!!!");
		}
	}

}
