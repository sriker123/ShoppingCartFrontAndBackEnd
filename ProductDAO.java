package com.niit.shoppincart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO
{
	public List<Product>  getcallProducts();
	
	public boolean save(Product product);
	
	public boolean Update(Product product);
	
	public boolean delete(Product product);
	
	public Product getProductById(String Prod_Id);
	
	public Product getProductByName(String Prod_Name);
}
