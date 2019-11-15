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

import com.niit.model.Product;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Product product=new Product();
		product.setProductname(req.getParameter("productname"));
		product.setPrice(Float.parseFloat(req.getParameter("price")));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setDescription(req.getParameter("description"));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			PreparedStatement ps=con.prepareStatement("insert into products (productname,price,quantity,description) values(?,?,?,?)");
			ps.setString(1, product.getProductname());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getDescription());
			ps.executeUpdate();
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Product added successfully!!!');"
					+ "window.location='displayproducts.jsp'"
					+ "</script>");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
