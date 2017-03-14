package com.niit.shoppincart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO 
{
	//Declare the methods related to CRUD operations

	//access_specifier return_type method_name(parameter_list) throws exception list
	//get all the categories
	public List<Category> getCallCategory();
	
	//create category
	public boolean save(Category category);
	
	//update category
	public boolean update(Category category);
	
	//delete category by category
	public boolean delete(Category category);
	//delete category by id
	 public boolean delete(String Cat_id); //polymorphism i.e, method overloading
	
	//get category by Id
	public Category getCategoryByID(String Cat_id);
	
	//get category by name
	public Category getCategoryByName(String Cat_name);
}




