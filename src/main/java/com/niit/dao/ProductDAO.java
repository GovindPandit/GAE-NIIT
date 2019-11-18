package com.niit.dao;

import com.niit.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productid);
	public boolean updateProduct(Product product);
	public boolean updateProductById(int productid);
}
