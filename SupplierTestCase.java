	package com.niit.shoppingcart.testcae;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppincart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierTestCase
{
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		
		supplier = context.getBean(Supplier.class);
		supplierDAO=context.getBean(SupplierDAO.class);
	}
	//test Cases
	@Test
	public void saveSupplierTestCase() {
		supplier.setSupp_Id("S07022017");
		supplier.setSupp_name("W.S.Retailers");
		supplier.setSupp_Desc("The retail distributes Mobiles and Apparels");
		
		boolean flag = supplierDAO.save(supplier);
		
		//Compare what you are expecting VS what you are getting from the save method
		
		Assert.assertEquals("saveSupplierCase",true, flag);
	}


}
