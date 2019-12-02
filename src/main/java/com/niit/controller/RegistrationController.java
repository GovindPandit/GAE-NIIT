package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.email.Email;
import com.niit.model.User;
import com.niit.servlet.ValidateUser;

@WebServlet(name = "RegistrationController",urlPatterns = "/RegistrationController")
public class RegistrationController extends HttpServlet
{
	UserDAO userDAO=new UserDAOImpl();

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User user=new User();
		user.setUsername(req.getParameter("username"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		
		String emailStatus=ValidateUser.validateEmail(user.getEmail());
		String usernameStatus=ValidateUser.validateUsername(user.getUsername());
		String passwordStatus=ValidateUser.validatePassword(user.getPassword());
		HttpSession hs=req.getSession();
		
		if(emailStatus.isEmpty() && usernameStatus.isEmpty() && passwordStatus.isEmpty())
		{
			
			boolean status=userDAO.addUser(user);
			if(status)
			{
				try
				{
					//Email email=new Email(user.getEmail(), "Registered Successfully!!!", "Welcome To GAE-Electo");
					//email.sendEmail();
					hs.setAttribute("msg", "Registered successfully!!!");
					hs.setAttribute("type", "success");
					hs.setAttribute("pagename", "login.jsp");
				}
				catch (Exception e) 
				{
					System.out.println(e);
				}

			}
			else
			{
				hs.setAttribute("msg", "Error!!!");
				hs.setAttribute("type", "error");
				hs.setAttribute("pagename", "register.jsp");				
			}
			resp.sendRedirect("popup.jsp");
		}
		else
		{
			hs.setAttribute("msgusername", usernameStatus);
			hs.setAttribute("msgemail", emailStatus);
			hs.setAttribute("msgpassword", passwordStatus);
			
			hs.setAttribute("user", user);
			
			hs.setAttribute("msg", "Error!!!");
			hs.setAttribute("type", "error");
			hs.setAttribute("pagename", "register.jsp");
			resp.sendRedirect("popup.jsp");
		}
		
	}
}
