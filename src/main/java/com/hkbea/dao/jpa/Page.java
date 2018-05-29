package com.hkbea.dao.jpa;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.Bindable;
import javax.persistence.metamodel.SingularAttribute;

/**
 * JPA/Hibernate 分页工具类
 * @author Chen
 *
 */
public abstract class Page {

	/**
	 * 升序、降序
	 * @author Chen
	 *
	 */
	public static enum SortDirection {
		ASC,
		DESC
	}
	
	/**
	 * 每个页面显示的记录数量。 -1这个值是特殊的，它意味着“没有限制；显示所有记录。”
	 */
	protected int size = -1;
	
	/**
	 * 记录总数
	 */
	protected long totalRecords;
	
	protected SingularAttribute sortAttribute;
	
	protected SortDirection sortDirection;
	
	protected SingularAttribute[] allowedAttributes;

	protected Page(int size, long totalRecords, SingularAttribute sortAttribute, SortDirection sortDirection, SingularAttribute... allowedAttributes) {
		super();
		this.size = size;
		this.totalRecords = totalRecords;
		this.sortAttribute = sortAttribute;
		this.sortDirection = sortDirection;
		this.allowedAttributes = allowedAttributes;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public SingularAttribute getSortAttribute() {
		return sortAttribute;
	}

	public void setSortAttribute(SingularAttribute<?, ?> sortAttribute) {
		if (sortAttribute == null)
            return;
        if (!Arrays.asList(allowedAttributes).contains(sortAttribute)) {
            throw new IllegalArgumentException(
                "Sorting by attribute not allowed: " + sortAttribute.getName()
            );
        }
		this.sortAttribute = sortAttribute;
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}

	public boolean isSortedAscending(){
		return SortDirection.ASC.equals(getSortDirection());
	}
	
	public SingularAttribute<?, ?>[] getAllowedAttributes() {
		return allowedAttributes;
	}

	public void setAllowedAttributes(SingularAttribute<?, ?>[] allowedAttributes) {
		this.allowedAttributes = allowedAttributes;
	}
	
	public boolean isMoreThanOneAvailable(){
		return getTotalRecords() != 0 && getTotalRecords() > getSize();
	}
	
	public boolean isAttributeDeclaredIn(SingularAttribute<?, ?> attribute, Bindable<?> bindable){
		return attribute != null && attribute.getDeclaringType().equals(bindable);
	}
	
	public boolean isApplicableFor(Bindable<?> bindable) {
		return isAttributeDeclaredIn(getSortAttribute(), bindable);
	}
	
	public void throwIfNotApplicableFor(Path<?> attributePath) {
		if(!isApplicableFor(attributePath.getModel())) {
			throw new IllegalArgumentException("Paging settings/sort attribute are not declared " +
                    "by model of query path: " + attributePath);
		}
	}
	
	/**
	 * 模板方法
	 * @param entityManager
	 * @param criteriaQuery
	 * @param attributePath
	 * @return
	 */
	public abstract <T> TypedQuery<T> createQuery(EntityManager entityManager, CriteriaQuery<T> criteriaQuery, Path<?> attributePath);
}
