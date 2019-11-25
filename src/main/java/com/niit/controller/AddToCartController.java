package com.niit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.model.User;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int productid=Integer.parseInt(req.getParameter("productid"));
		HttpSession hs=req.getSession();
		User user=(User)hs.getAttribute("user");
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			PreparedStatement ps=con.prepareStatement("insert into cartitems (userid,productid) values(?,?)");
			ps.setInt(1, user.getUserid());
			ps.setInt(2, productid);
			ps.executeUpdate();
			
			hs.setAttribute("msg", "Cart Item Added Successfully!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "displaycartitems.jsp");
			resp.sendRedirect("popup.jsp");
		}
		catch (Exception e) 
		{
			System.out.println(e);
			// TODO: handle exception
		}
	
	}
}
