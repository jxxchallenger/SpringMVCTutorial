package test.dao.jdbc;

import java.util.List;
import java.util.Map;

import com.hkbea.domain.city.City;

public interface CityDao {

	List<City> getCities();
	
	List<Map<String, Object>> getCityAsMap();
	
	List<City> getCities(Object[] args);
	
	List<Map<String, Object>> getCityByParentIdAndCityCode(int parentId, String cityCode);
}
