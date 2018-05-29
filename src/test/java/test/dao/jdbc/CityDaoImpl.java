package test.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hkbea.domain.city.City;

@Repository
public class CityDaoImpl implements CityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<City> getCities() {
		final String sql = "SELECT ID, NAME, PARENT_ID, SHORT_NAME, LETTER, CITY_CODE, PIN_YIN FROM CITY WHERE 1 = 1 LIMIT 20";
		return this.jdbcTemplate.query(sql, new CityMapper());
	}

	@Override
	public List<Map<String, Object>> getCityAsMap(){
		final String sql = "SELECT ID, NAME, PARENT_ID, SHORT_NAME, LETTER, CITY_CODE, PIN_YIN FROM CITY WHERE 1 = 1 LIMIT 20";
		
		return this.jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public List<City> getCities(Object[] args) {
		final String sql = "SELECT ID, NAME, PARENT_ID, SHORT_NAME, LETTER, CITY_CODE, PIN_YIN FROM CITY WHERE 1 = 1 AND PARENT_ID = ? AND CITY_CODE = ? LIMIT 20";
		int[] argTypes = {Types.INTEGER, Types.VARCHAR};
		
		
		return this.jdbcTemplate.query(sql, args, argTypes, new CityMapper());
	}
	
	@Override
	public List<Map<String, Object>> getCityByParentIdAndCityCode(int parentId, String cityCode) {
		final String sql = "SELECT ID, NAME, PARENT_ID, SHORT_NAME, LETTER, CITY_CODE, PIN_YIN FROM CITY WHERE 1 = 1 AND PARENT_ID = :parentId AND CITY_CODE = :cityCode LIMIT 20";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		params.put("cityCode", cityCode);
		
		return this.namedParameterJdbcTemplate.queryForList(sql, params);
	}
	
	private static final class CityMapper implements RowMapper<City> {

		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new City(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
		
	}

}
