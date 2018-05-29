package test.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public abstract class AbstractHibernateDao<T> {

	@Inject
	protected SessionFactory sessionFactory;
	
	private Class<T> clazz;

	protected AbstractHibernateDao() {
		super();
		
		//通过Java反射机制设置clazz
	}

	protected final Class<T> getClazz() {
		return clazz;
	}

	/**
	 * 也可以通过子类的构造方法调用setClazz方法设置clazz
	 * @param clazz
	 */
	protected final void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public final Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public T findOne(Serializable id){
		return this.getCurrentSession().find(clazz, id);
	}
	
	public List<T> findAll(){
		return this.getCurrentSession().createQuery("from " + clazz.getName(), clazz).getResultList();
	}
	
	public List<T> findByNamedProperty(String namedQuery, Map<String, Object> params){
		Query<T> query = this.getCurrentSession().createNamedQuery(namedQuery, clazz);
		for(Entry<String, Object> entry: params.entrySet()){
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}
	
	public void save(T entity){
		this.getCurrentSession().persist(entity);
	}
	
	public void update(T entity){
		this.getCurrentSession().merge(entity);
	}
	
	public void delete(T entity){
		this.getCurrentSession().remove(entity);
	}
	
	public void delete(Serializable id){
		T entity = findOne(id);
		delete(entity);
	}
	
	/*
	 * 使用Spring的项目中可以实现InitializingBean接口，在afterPropertiesSet设置clazz
	@Override
	public void afterPropertiesSet() throws Exception {
		
		
	}
	*/
}
