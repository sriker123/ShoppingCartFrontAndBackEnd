package com.niit.shoppingcart.testcae;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppincart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product    =  context.getBean(Product.class);
		productDAO =  context.getBean(ProductDAO.class);
	}
	
	//testCases
	@Test
	public void createProductTestCase()
	{
		product.setProd_Id("PD06032017");
		product.setProd_Name("Nokia 3310");
		product.setProd_Price("Rs.5999");
		product.setProd_Description("nokia nw");
		
		boolean flag = productDAO.save(product);
		
		//Compare what you are expecting VS what you are getting from the save method
		
		Assert.assertEquals("createProductTestCase", true, flag);
	}

}
