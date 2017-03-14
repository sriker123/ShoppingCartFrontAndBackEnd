package com.niit.shoppingcart.testcae;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppincart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

public class UserTestCase {


	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static AnnotationConfigApplicationContext  context;
	
	@BeforeClass //we user if we want to execute any code before executing any other test case
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user    = context.getBean(User.class);
		userDAO = context.getBean(UserDAO.class);
	}
	
	/*@Test
	public void validateCredentialTestCase()
	{
		boolean flag =userDAO.validate("spike", "qwerty@123");
		
		Assert.assertEquals("ValidateCredentialsTestCase", true, flag);
		
	}
	*/
	/*@Test
	public void saveUserTestCase() {
		user.setId("johny");
		user.setName("depp");
		user.setPassword("qwerty@123");
		user.setMail("johnydepp@gmail.com");
		user.setContact("9598567823");
		user.setRole("Admin");
		
		boolean flag = userDAO.save(user);
		
		//Compare what you are expecting VS what you are getting from the save method
		
		Assert.assertEquals("saveUserTestCase",true, flag);
	}*/
	/*@Test
	public void updateUserTestCase() {
		User user= (User) userDAO.getUserbyid("spike");
		
		user.setName("Sriker");

		Assert.assertEquals(true, userDAO.update(user));
	}*/
	
	@Test
	public void deleteUserTestCase()
	{
			User user = userDAO.getUser("ali");
			user.setId("ali");
			boolean flag = userDAO.delete(user);
			Assert.assertEquals(true, flag);
			
	}


}
