package com.niit.shoppingcart.dao.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppincart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO") //to create instance in test case
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionfactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCallCategory() { // select*from category - SQL
												// Query - Mention the Table
												// name
												// from Category -> HQL -
												// mention Domain Class name not
												// table name
		return sessionfactory.getCurrentSession().createQuery("from Category").list();
		// createQuery => converts the hibernate query into database specific
		// language

	}

	
	public boolean save(Category category) {
		try // to check the line is executed successfully or not use try and
			// catch
		{
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {

		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.update(category);
			
			session.getTransaction().commit();
			session.close();
			return true;
		
	
		} catch (Exception e) {
			e.printStackTrace();//it will print the error in the console or server console -> similar to SOP
								//Package,class,method line number from which place you are calling
			return false;
		}

	}

	public boolean delete(Category category) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.delete(category);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*public boolean delete(String id) {
		try {
			sessionfactory.getCurrentSession().get(Category.class, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}
*/
	//this method will return 
	public Category getCategoryByID(String Cat_id) {
		// get -> it is similar to select * from category where id='mobile'
		// return (Category)
		// sessionfactory.getCurrentSession().get(Category.class, id);
		return (Category) sessionfactory.getCurrentSession().createQuery("from Category where id='" + Cat_id + "'")
				.uniqueResult();

	}

	public Category getCategoryByName(String Cat_name) {

		return (Category) sessionfactory.getCurrentSession().createQuery("from Category where name='" + Cat_name + "'")
				.uniqueResult();
	}

	public boolean delete(String Cat_id) {
		
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.delete(getCallCategory());
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
