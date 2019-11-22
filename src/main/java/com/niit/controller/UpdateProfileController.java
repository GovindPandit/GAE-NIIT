package com.niit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet 
{
	UserDAO userDAO=new UserDAOImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User user=new User();
		user.setUserid(Integer.parseInt(req.getParameter("userid")));
		user.setUsername(req.getParameter("username"));
		user.setEmail(req.getParameter("email"));
		System.out.println(user.getUserid());
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		
		
		boolean status=userDAO.updateUser(user);
		HttpSession hs=req.getSession();
		if(status)
		{
			hs.setAttribute("msg", "Profile Updated successfully!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "login.jsp");
		}
		else
		{
			hs.setAttribute("msg", "Error!!!");
			hs.setAttribute("type", "error");
			hs.setAttribute("pagename", "profile.jsp");
		}
		resp.sendRedirect("popup.jsp");
	}

}
