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

import com.niit.dao.ProductDAO;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.datasource.DataSource;

@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet
{
	ProductDAO productDAO=new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int cartitemid=Integer.parseInt(req.getParameter("cartitemid"));
		HttpSession hs=req.getSession();
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from cartitems where cartitemid=?");
			ps.setInt(1, cartitemid);
			ps.executeUpdate();
			hs.setAttribute("msg", "Product removed from cart!!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "displaycartitems.jsp");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		resp.sendRedirect("popup.jsp");
	}
}
