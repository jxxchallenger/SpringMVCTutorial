package test.server.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkbea.domain.city.City;

import test.dao.jdbc.CityDao;

@Service
public class CityServerImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getCities() {
		
		return this.cityDao.getCities();
	}

	@Override
	public List<Map<String, Object>> getCityAsMap() {
		
		return this.cityDao.getCityAsMap();
	}

	@Override
	public List<City> getCityByParentIdAndCityCode(int parentId, String cityCode) {
		
		return this.cityDao.getCities(new Object[]{parentId, cityCode});
	}

	@Override
	public List<Map<String, Object>> getCityByParentIdAndCityCode(City city) {
		
		return this.cityDao.getCityByParentIdAndCityCode(city.getParentId(), city.getCityCode());
	}

}
