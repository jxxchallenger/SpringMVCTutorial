package com.hkbea.entity.city;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CITY")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1479744756110432486L;

	private Long id;
	
	private String name;
	
	private Long parentId;
	
	private String shortName;
	
	private String letter;
	
	private String cityCode;
	
	private String pinyin;
	
	protected City() {
		super();
	}

	public City(String name, Long parentId, String shortName, String letter, String cityCode, String pinyin) {
		super();
		this.name = name;
		this.parentId = parentId;
		this.shortName = shortName;
		this.letter = letter;
		this.cityCode = cityCode;
		this.pinyin = pinyin;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="PARENT_ID")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name="SHORT_NAME")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name="LETTER")
	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	@Column(name="CITY_CODE")
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name="PIN_YIN")
	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
}
