package com.niit.daoimpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.niit.dao.ProductDAO;
import com.niit.datasource.DataSource;
import com.niit.model.Product;

public class ProductDAOImpl implements ProductDAO 
{

	@Override
	public boolean addProduct(Product product,InputStream is) 
	{
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into products (productname,price,quantity,description,image) values(?,?,?,?,?)");
			ps.setString(1, product.getProductname());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getDescription());
			ps.setBlob(5, is);
			ps.executeUpdate();
			con.close();
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
			Connection con=DataSource.getConnection();
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
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("update products set productname=?,price=?,quantity=?,description=? where productid=?");
			ps.setString(1, product.getProductname());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getDescription());
			ps.setInt(5, product.getProductid());
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
	public boolean displayProductById(int productid) 
	{
		return false;
	}

}

