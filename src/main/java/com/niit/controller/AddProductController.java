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

import com.niit.dao.ProductDAO;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.model.Product;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet 
{
	ProductDAO productDAO=new ProductDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Product product=new Product();
		product.setProductname(req.getParameter("productname"));
		product.setPrice(Float.parseFloat(req.getParameter("price")));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setDescription(req.getParameter("description"));
			
		boolean status=productDAO.addProduct(product);
		if(status)
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Product added successfully!!!');"
					+ "window.location='displayproducts.jsp'"
					+ "</script>");
		}
		else
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Error!!!');"
					+ "window.location='addproduct.jsp'"
					+ "</script>");
		}
		
	}
}
