package com.hkbea.domain.city;

public class City {

	private int id;
	
	private String name;
	
	private int parentId;
	
	private String shortName;
	
	private String letter;
	
	private String cityCode;
	
	private String pinyin;

	public City() {
		super();
	}

	public City(int id, String name, int parentId, String shortName, String letter, String cityCode, String pinyin) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.shortName = shortName;
		this.letter = letter;
		this.cityCode = cityCode;
		this.pinyin = pinyin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
}
