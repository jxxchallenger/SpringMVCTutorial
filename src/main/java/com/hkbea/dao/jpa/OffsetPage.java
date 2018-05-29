package com.hkbea.dao.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.SingularAttribute;

public class OffsetPage extends Page {

	protected int current = 1;
	
	public OffsetPage(int size, long totalRecords, SingularAttribute<?, ?> sortAttribute, SortDirection sortDirection, SingularAttribute<?, ?>... allowedAttributes) {
		super(size, totalRecords, sortAttribute, sortDirection, allowedAttributes);
		
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getNext(){
		return getCurrent() + 1;
	}
	
	public int getPrevious(){
		return getCurrent() - 1;
	}
	
	public int getFirst(){
		return 1;
	}
	
	public long getLast(){
		long lastPage = getTotalRecords() / getSize();
		if(getTotalRecords() % getSize() == 0){
			lastPage--;
		}
		return lastPage + 1;
	}
	
	public long getRangeStart(){
		return (getCurrent() - 1) * getSize();
	}
	
	public int getRangeStartInteger() throws ArithmeticException {
		return new BigDecimal(getRangeStart()).intValueExact();
	}
	
	public long getRangeEnd(){
		long firstIndex = getRangeStart();
		long pageIndex = getSize() - 1;
		long lastIndex = Math.max(0, getTotalRecords() - 1);
		return Math.min(firstIndex + pageIndex, lastIndex);
	}
	
	public int getRangeEndInteger() throws ArithmeticException {
		return new BigDecimal(getRangeEnd()).intValueExact();
	}
	
	/**
	 * 判断是否可以往前翻页
	 * @return
	 */
	public boolean isPreviousAvailable(){
		return getRangeStart() + 1 > getSize();
	}
	
	/**
	 * 判断是否可以往后翻页
	 * @return
	 */
	public boolean isNextAvailable(){
		return getTotalRecords() - 1 > getRangeEnd();
	}
	
	@Override
	public <T> TypedQuery<T> createQuery(EntityManager entityManager, CriteriaQuery<T> criteriaQuery, Path<?> attributePath) {
		
		throwIfNotApplicableFor(attributePath);
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		Path<?> sortPath = attributePath.get(getSortAttribute());
		
		criteriaQuery.orderBy(isSortedAscending() ? cb.asc(sortPath) : cb.desc(sortPath));
		
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		
		query.setFirstResult(getRangeStartInteger());
		
		if(getSize() != -1){
			query.setMaxResults(getSize());
		}
		
		return query;
	}
}
