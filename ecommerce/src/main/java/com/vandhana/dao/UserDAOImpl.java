package com.vandhana.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandhana.dao.UserDAO;
import com.vandhana.model.User;

@Transactional
@Repository
public  class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	
		public List<User> getAlluser() {
		Session session = sessionFactory.openSession();
		List<User> b1=session.createQuery("from User",User.class).list();
		session.close();
		return b1;
	}

	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();

		User a1=new User();
		a1=session.get(User.class, id);
		transaction.commit();
		session.close();
		
		return a1;

	}
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
      
        }

	public void upUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
        
		
	}

	
}


	


