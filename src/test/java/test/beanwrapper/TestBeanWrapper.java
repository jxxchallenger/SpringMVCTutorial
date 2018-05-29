package test.beanwrapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.hkbea.domain.city.City;

public class TestBeanWrapper {

	@Test
	public void showBeanWrapper(){
		City city = new City();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(city);
		bw.setPropertyValue("name", "深圳");
		assertEquals(city.getName(), "深圳");
	}
}
