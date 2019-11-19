package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.ProductDAO;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.model.Product;

@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet
{
	ProductDAO productDAO=new ProductDAOImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Product product=new Product();
		product.setProductid(Integer.parseInt(req.getParameter("productid")));
		product.setProductname(req.getParameter("productname"));
		product.setPrice(Float.parseFloat(req.getParameter("price")));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setDescription(req.getParameter("description"));
		
		boolean status=productDAO.updateProduct(product);
		HttpSession hs=req.getSession();
		if(status)
		{
			hs.setAttribute("msg", "Product updated successfully!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "displayproducts.jsp");

		}
		else
		{
			hs.setAttribute("msg", "Error !!!");
			hs.setAttribute("type", "error");
			hs.setAttribute("pagename", "displayproducts.jsp");

		}
		resp.sendRedirect("popup.jsp");
	}
}
