package app05a.domain;

import java.io.Serializable;

public class Radio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2196551236546559799L;
	
	private String label;
	
	private int value;

	public Radio(String label, int value) {
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
