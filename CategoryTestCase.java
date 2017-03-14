package com.niit.shoppingcart.testcae;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppincart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryTestCase {

	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init () //the method name can be anything but for our reference we used init to initialize the process
	{
		//this method should be executed only once
		//the method is static because to use the before annotation, the method ought to be static else we will get run-time err
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*"); 
		context.refresh();
		
		category = (Category) context.getBean(Category.class);
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}



	//Test cases
	@Test
	public void createCategoryTestCase()
	{
		category.setCat_Id("CG02022017");
		category.setCat_Name("Mobile");
		category.setCat_Description("This is mobile category");
		
		
		boolean flag = categoryDAO.save(category);
		
		//Compare what you are expecting VS what you are getting from the save method
		
		Assert.assertEquals("createCategoryTestCase", true, flag);
	}
	
	/*@Test
	public void updateCategoryTestCase() {
		Category category = (Category) categoryDAO.getCategoryByID("Apperel_003");
		//Category category = (Category) categoryDAO.getCategoryByName("Samsung edge");
		//category.setCat_Name("Samsung");
		//category.setCat_Description("This is chNGED DESC***");
		category.setCat_Name("Electronic");

		Assert.assertEquals(true, categoryDAO.update(category));
	}*/

	/*@SuppressWarnings("deprecation")
	@Test
	public void deleteCategoryTestCase()
	{
		Category category = categoryDAO.getCategoryByID("CG03022017");
		category.setCat_Id("CG03022017");
			boolean flag = categoryDAO.delete(category);
			junit.framework.Assert.assertEquals(true,flag);
	}*/
	
	/*@Test
	public void deleteCategoryTestCase()
	{
		Category category = categoryDAO.getCategoryByName("Samsung edge");//creating an instance by getting the category and using the instance to do operations
		category.setCat_Id("5");
			boolean flag = categoryDAO.delete(category);
			junit.framework.Assert.assertEquals(true,flag);
	}
*/	
	/*@Test
	public void getCategoryIDTestCase()
	{
		
		category = categoryDAO.getCategoryByID("Electronics_005");
		Assert.assertNotNull("getCategoryIDTestCase",category);
		//assertEquals(, category);
		
	}*/
	/*@Test
	public void getAllCategoriesTestCase()
	{
		int recordsFromDAO= categoryDAO.getCallCategory().size();
		assertEquals(2, recordsFromDAO);
	}*/
	
}
