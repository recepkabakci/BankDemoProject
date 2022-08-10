package com.bilgeadam.dao;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateSession;


public class EntityController<T> implements IRepository<T> {

	@Override
	public void create(T entity) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
    }

	@Override
	public void update(long id, T entity) {	
	}

	@Override
	public void delete(long id) {
		
	}
	
}
