package com.niit.dao;

import com.niit.model.Product;

public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean updateProductById(int productid);
}
