package test.server.jdbc;

import java.util.List;
import java.util.Map;

import com.hkbea.domain.city.City;

public interface CityService {

	List<City> getCities();
	
	List<Map<String, Object>> getCityAsMap();
	
	List<City> getCityByParentIdAndCityCode(int parentId, String cityCode);
	
	List<Map<String, Object>> getCityByParentIdAndCityCode(City city);
}
