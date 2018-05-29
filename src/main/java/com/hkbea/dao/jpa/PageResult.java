package com.hkbea.dao.jpa;

import java.util.List;

public class PageResult<T> {

	/**
	 * 数据
	 */
	private List<T> result;
	
	/**
	 * 记录总数
	 */
	private long totalRecords;
	
	/**
	 * 当前页码
	 */
	private int currentPage;

	public PageResult() {
		super();
		
	}

	public PageResult(List<T> result, long totalRecords, int currentPage) {
		super();
		this.result = result;
		this.totalRecords = totalRecords;
		this.currentPage = currentPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
