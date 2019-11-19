package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

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
		
			boolean status=userDAO.addUser(user);
			HttpSession hs=req.getSession();
			if(status)
			{
				hs.setAttribute("msg", "Registered successfully!!!");
				hs.setAttribute("type", "success");
				hs.setAttribute("pagename", "login.jsp");

			}
			else
			{
				hs.setAttribute("msg", "Error!!!");
				hs.setAttribute("type", "error");
				hs.setAttribute("pagename", "register.jsp");				
			}
			resp.sendRedirect("popup.jsp");
			
		
	}
}
