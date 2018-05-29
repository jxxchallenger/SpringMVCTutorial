package app05a.domain;

import java.io.Serializable;

public class Form implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5610630110185474701L;
	
	private long id;
	
	private String input;
	
	private String password;
	
	private String textArea;
	
	private String checkbox;
	
	private String[] checkboxs;
	
	private String radiobutton;
	
	private String radiobuttons;
	
	private String select;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String[] getCheckboxs() {
		return checkboxs;
	}

	public void setCheckboxs(String[] checkboxs) {
		this.checkboxs = checkboxs;
	}

	public String getRadiobutton() {
		return radiobutton;
	}

	public void setRadiobutton(String radiobutton) {
		this.radiobutton = radiobutton;
	}

	public String getRadiobuttons() {
		return radiobuttons;
	}

	public void setRadiobuttons(String radiobuttons) {
		this.radiobuttons = radiobuttons;
	}
	
	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}


}
