package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.ProductDAO;
import com.niit.daoimpl.ProductDAOImpl;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet
{
	ProductDAO productDAO=new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int productid=Integer.parseInt(req.getParameter("productid"));
		boolean status=productDAO.deleteProduct(productid);
		
		if(status)
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Product deleted successfully!!!');"
					+ "window.location='displayproducts.jsp'"
					+ "</script>");
		}
		else
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Error!!!');"
					+ "window.location='displayproducts.jsp'"
					+ "</script>");
		}
	}
}
