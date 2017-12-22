package com.vandhana.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandhana.dao.CategoryDAO;
import com.vandhana.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
		@Autowired
		private SessionFactory sessionFactory;

		public void addCategory(Category category) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(category);
			transaction.commit();
			session.close();

		}

		
		public List<Category> getAllCategory() {
			Session session = sessionFactory.openSession();
			List<Category> c2 = session.createQuery("from Category", Category.class).list();
			session.close();
			return c2;

		}

		
		public Category getCategoryById(int id) {

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Category c1 = new Category();
			c1 = session.get(Category.class, id);
			transaction.commit();
			session.close();
			return c1;

		}

		
		public void delete(int id) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(getCategoryById(id));
			transaction.commit();
			session.close();
		}

	}


