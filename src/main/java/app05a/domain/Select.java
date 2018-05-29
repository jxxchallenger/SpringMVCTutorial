package app05a.domain;

import java.io.Serializable;

public class Select implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2333305582764774662L;

	private int id;
	
	private String label;
	
	private String value;

	public Select(int id, String label, String value) {
		super();
		this.id = id;
		this.label = label;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
