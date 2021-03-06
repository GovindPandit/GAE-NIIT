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

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet
{
	ProductDAO productDAO=new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int productid=Integer.parseInt(req.getParameter("productid"));
		boolean status=productDAO.deleteProduct(productid);
		
		HttpSession hs=req.getSession();
		if(status)
		{
			hs.setAttribute("msg", "Product Deleted successfully!!!");
			hs.setAttribute("type", "success");
			hs.setAttribute("pagename", "displayproducts.jsp");
		}
		else
		{
			hs.setAttribute("msg", "Error!!!");
			hs.setAttribute("type", "error");
			hs.setAttribute("pagename", "displayproducts.jsp");
		}
		resp.sendRedirect("popup.jsp");
	}
}
