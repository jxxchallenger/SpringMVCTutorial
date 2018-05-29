package com.hkbea.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Chen
 *
 * @param <T>
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	private SessionFactory sessionFactory;
	
	private final Class<T> entityClass;

	protected GenericDAOImpl(SessionFactory sessionFactory, Class<T> entityClass) {
		super();
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	protected final Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public T findById(Serializable id) {
		
		return findById(id, LockModeType.NONE);
	}

	@Override
	public T findById(Serializable id, LockModeType lockModeType) {
		
		return this.getCurrentSession().find(entityClass, id, lockModeType);
	}

	@Override
	public T findReferenceById(Serializable id) {
		
		return this.getCurrentSession().getReference(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = this.getCurrentSession().getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return this.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Long getCount() {
		CriteriaQuery<Long> criteriaQuery = this.getCurrentSession().getCriteriaBuilder().createQuery(Long.class);
		criteriaQuery.select(this.getCurrentSession().getCriteriaBuilder().count(criteriaQuery.from(entityClass)));
		
		return this.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public void save(T entity) {
		
		this.getCurrentSession().persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(T entity) {
		
		return (T) this.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(Serializable id) {
		
		T entity = findById(id);
		delete(entity);
	}

	@Override
	public void delete(T entity) {
		
		this.getCurrentSession().remove(entity);
	}

	@Override
	public void checkVersion(T entity, boolean forceUpdate) {
		
		this.getCurrentSession().lock(
	            entity,
	            forceUpdate
	                ? LockModeType.OPTIMISTIC_FORCE_INCREMENT
	                : LockModeType.OPTIMISTIC
	        );
	}

}
