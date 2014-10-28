package org.lalosuarez.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.hibernate.SessionFactoryService;

public class LineaDaoImpl implements LineaDao {

	private SessionFactoryService sessionFactoryService;
	
	@Override
	public void save(Linea object) {
		
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			if (object.getId() == 0) {
				session.save(object);
			} else {
				session.update(object);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("delete Linea where id = :id");
			query.setParameter("id", id);
			
			query.executeUpdate();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Linea> findAll() {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Linea> list = null;
		
		try {
			session.beginTransaction();
	
			Criteria criteria = session.createCriteria(Linea.class)
				.addOrder(Order.asc("nombre"));
			criteria.setCacheable(true);
			
			list = criteria.list();
							
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
			
		return list;
	}

	@Override
	public Linea find(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		Linea object = null;
		
		try {
			session.beginTransaction();
			
			object = (Linea) session.get(Linea.class, id);
									
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
			
		return object;
	}

	public SessionFactoryService getSessionFactoryService() {
		return sessionFactoryService;
	}

	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}
}
