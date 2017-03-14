package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppincart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;


@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionfactory = sessionFactory;
	}
	
	private Session getSession()
	{
		return  sessionfactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
	
		return getSession().createQuery("from niit").list();
	}

	public User getUser(String id) {
		//return (Category) sessionfactory.getCurrentSession().createQuery("from Category where id='" + Cat_id + "'")
		//.uniqueResult();
		return (User) sessionfactory.getCurrentSession().createQuery("from User where id='"+id+"'").uniqueResult();
				}

	public boolean save(User user) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.save(user);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.update(user);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(User user) {
		try {
			org.hibernate.Session session = sessionfactory.openSession();
			session.beginTransaction();

			session.delete(user);
			
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean validate(String id, String password) {
		String hql = "from User Where id='"+id+ "' and password='"+password+"'";
		if(getSession().createQuery(hql).uniqueResult()==null)
		{
			return false;	
		}
		return true;
	}

	
	

}
