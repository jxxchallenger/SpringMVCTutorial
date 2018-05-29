package com.hkbea.dao.jpa.city;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hkbea.dao.jpa.GenericDAOImpl;
import com.hkbea.entity.city.City;

@Repository
public class CityDAOImpl extends GenericDAOImpl<City> implements CityDAO {

	@Autowired
	public CityDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory, City.class);
		
	}

}
