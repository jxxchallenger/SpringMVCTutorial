package com.hkbea.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

/**
 * JPA/Hibernate 通用DAO接口
 * @author Chen
 *
 * @param <T>
 */
public interface GenericDAO<T> {

	/**
	 * 根据ID查询T类型的记录
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	
	/**
	 * 根据ID查询T类型的记录
	 * @param id
	 * @param lockModeType
	 * @return
	 */
	T findById(Serializable id, LockModeType lockModeType);
	
	/**
	 * 获取指定ID的记录的代理
	 * @param id
	 * @return
	 */
	T findReferenceById(Serializable id);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 查询记录总数
	 * @return
	 */
	Long getCount();
	
	/**
	 * 新增记录
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 更新记录
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**
	 * 删除指定id的记录
	 * @param id
	 */
	void delete(Serializable id);
	
	/**
	 * 删除记录
	 * @param entity
	 */
	void delete(T entity);
	
	void checkVersion(T entity, boolean forceUpdate);
	
	
}
