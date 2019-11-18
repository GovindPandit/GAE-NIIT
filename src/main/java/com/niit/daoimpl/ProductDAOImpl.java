package com.niit.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOImpl implements ProductDAO 
{

	@Override
	public boolean addProduct(Product product) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			PreparedStatement ps=con.prepareStatement("insert into products (productname,price,quantity,description) values(?,?,?,?)");
			ps.setString(1, product.getProductname());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getDescription());
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(int productid) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://34.67.195.30:3306/niitgae","root","root");
			PreparedStatement ps=con.prepareStatement("delete from products where productid=?");
			ps.setInt(1, productid);
			ps.executeUpdate();
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		return false;
	}

	@Override
	public boolean updateProductById(int productid) 
	{
		return false;
	}

}
