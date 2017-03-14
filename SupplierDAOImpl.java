package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppincart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionfactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionfactory = sessionFactory;
	}
	public Session getSession()
	{
		return sessionfactory.getCurrentSession();
	}

	public List<Supplier> list() {
		return getSession().createQuery("from niit").list();
	}

	public Supplier getSupplierbyid(String Supp_Id) {
		return (Supplier) sessionfactory.getCurrentSession().createQuery("from Supplier where id='"+Supp_Id+"'").uniqueResult();
	}

	public boolean save(Supplier supplier) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.save(supplier);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(Supplier supplier) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.delete(supplier);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(Supplier supplier) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.update(supplier);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
