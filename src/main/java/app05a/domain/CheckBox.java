package app05a.domain;

import java.io.Serializable;

public class CheckBox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320874523764706684L;
	
	private String label;
	
	private String value;

	public CheckBox(String label, String value) {
		super();
		this.label = label;
		this.value = value;
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
