package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppincart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionfactory;

	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Product> getcallProducts() {
		
		return sessionfactory.getCurrentSession().createQuery("from product").list();
	}

	public boolean save(Product product) {
		
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			return true;
		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Update(Product product) {
		
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			session.close();
			return true;
		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Product product) {
		
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.close();
			return true;
		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Product getProductById(String Prod_Id) {
		
		return (Product) sessionfactory.getCurrentSession().createQuery("From Product where Id='"+Prod_Id+"'").uniqueResult();
	}

	public Product getProductByName(String Prod_Name) {
		
		return (Product) sessionfactory.getCurrentSession().createQuery("From Product where name='"+Prod_Name+"'").uniqueResult();
	}
	
}
