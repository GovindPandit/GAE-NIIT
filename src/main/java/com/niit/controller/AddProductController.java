package com.niit.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.niit.dao.ProductDAO;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.model.Product;

@WebServlet("/AddProductController")
@MultipartConfig(maxFileSize = 99999999L)
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
		
		Part part=req.getPart("image");
		InputStream is=part.getInputStream();
			
		
		HttpSession hs=req.getSession();
		boolean status=productDAO.addProduct(product,is);
		if(status)
		{
			hs.setAttribute("msg", "Product Added successfully!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "displayproducts.jsp");
		}
		else
		{
			hs.setAttribute("msg", "Error!!!");
			hs.setAttribute("type", "error");
			hs.setAttribute("pagename", "addproduct.jsp");
		}
		resp.sendRedirect("popup.jsp");
		
	}
}
