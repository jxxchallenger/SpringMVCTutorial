package com.hkbea.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hkbea.dao.CityDao;
import com.hkbea.domain.city.City;

@Repository
public class CityDaoJdbcImpl implements CityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<City> getAll() {
		final String sql = "SELECT ID, NAME, PARENT_ID, SHORT_NAME, LETTER, CITY_CODE, PIN_YIN FROM CITY WHERE 1 = 1";
		
		return jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				return con.prepareStatement(sql);
			}
		}, new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				City city = new City();
				city.setId(rs.getInt(1));
				city.setName(rs.getString(2));
				city.setParentId(rs.getInt(3));
				city.setShortName(rs.getString(4));
				city.setLetter(rs.getString(5));
				city.setCityCode(rs.getString(6));
				city.setPinyin(rs.getString(7));
				
				return city;
			}
		});
	}

}
