package org.lalosuarez.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.hibernate.SessionFactoryService;

public class EstacionDaoImpl implements EstacionDao {
	
	private SessionFactoryService sessionFactoryService;
	
	@Override
	public void save(Estacion object) {
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
			
			Query query = session.createQuery("delete Estacion where id = :id");
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
	public List<Estacion> findAll() {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Estacion> list = null;
		
		try {
			session.beginTransaction();
	
			Criteria criteria = session.createCriteria(Estacion.class)
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
	public Estacion find(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		Estacion object = null;
		
		try {
			session.beginTransaction();
			
			object = (Estacion) session.get(Estacion.class, id);
			
			if (object != null)
				Hibernate.initialize(object.getLineas());
						
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
			
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estacion> findEstacionesByLinea(int id) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Estacion> list = null;
		
		try {
			session.beginTransaction();
	
			Query query = session.createQuery("select e from Estacion e join e.lineas l where l.id = :id");
			query.setInteger("id", id).setCacheable(true);
			
			list = (List<Estacion>) query.list();
							
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estacion> findByParameter(String searchParameter) {
		Session session = sessionFactoryService.getSessionFactory().openSession();
		
		List<Estacion> list = null;
		
		try {
			session.beginTransaction();
			
			Query query = session.createQuery("SELECT e FROM Estacion e INNER JOIN e.lineas l "
				+ "WHERE e.nombre LIKE :searchParameter OR l.nombre LIKE :searchParameter");
			
			query.setString("searchParameter", "%" + searchParameter + "%");
			query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			query.setCacheable(true);

			list = (List<Estacion>) query.list();			
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}	
	
	public SessionFactoryService getSessionFactoryService() {
		return sessionFactoryService;
	}

	public void setSessionFactoryService(SessionFactoryService sessionFactoryService) {
		this.sessionFactoryService = sessionFactoryService;
	}
}
