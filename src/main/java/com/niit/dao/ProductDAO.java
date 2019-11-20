package com.niit.dao;

import java.io.InputStream;

import com.niit.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product product,InputStream is);
	public boolean deleteProduct(int productid);
	public boolean updateProduct(Product product);
	public boolean displayProductById(int productid);
}
