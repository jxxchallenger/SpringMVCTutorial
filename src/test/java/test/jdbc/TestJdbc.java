package test.jdbc;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hkbea.domain.city.City;

import test.server.jdbc.CityService;

public class TestJdbc{

	private CityService cityService;

	@SuppressWarnings("resource")
	@BeforeAll
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/jdbc/ApplicationContext-JDBC.xml");
		this.cityService = context.getBean(CityService.class);
	}

	@Test
	public void testBasicUsage() {
		/*List<City> cities = this.cityService.getCities();
		System.out.println(cities.size());
		
		List<Map<String, Object>> maps = this.cityService.getCityAsMap();
		
		System.out.println(maps.size());*/
		List<City> cityByParentIdAndCityCode = this.cityService.getCityByParentIdAndCityCode(440300, "0755");
		System.out.println(cityByParentIdAndCityCode.size());
		
		City city2 = new City();
		city2.setParentId(440300);
		city2.setCityCode("0755");
		List<Map<String, Object>> cities2 = this.cityService.getCityByParentIdAndCityCode(city2);
		System.out.println(cities2.size());
	}

	@AfterAll
	public void tearDown() throws Exception {
		
	}

}
