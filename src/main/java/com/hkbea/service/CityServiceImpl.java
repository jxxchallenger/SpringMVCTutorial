package com.hkbea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkbea.dao.CityDao;
import com.hkbea.domain.city.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getAll() {
		
		return cityDao.getAll();
	}

}
