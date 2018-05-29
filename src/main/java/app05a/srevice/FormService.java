package app05a.srevice;

import java.util.List;
import java.util.Map;

import app05a.domain.CheckBox;
import app05a.domain.Form;
import app05a.domain.Radio;
import app05a.domain.Select;

public interface FormService {

	List<CheckBox> getAllCheckBox();
	
	List<Radio> getAllRadio();
	
	Map<Integer, Select> getAllSelect();
	
	void saveForm(Form form);
	
	List<Form> getAllForm();
	
	Form getForm(long id);
	
	void updateForm(Form form);
}
