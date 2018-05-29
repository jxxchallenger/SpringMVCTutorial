package app05a.srevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import app05a.domain.CheckBox;
import app05a.domain.Form;
import app05a.domain.Radio;
import app05a.domain.Select;

@Service
public class FormServiceImpl implements FormService {

	private List<CheckBox> checkBoxs;
	
	private List<Radio> radios;
	
	private Map<Integer, Select> selectMap;
	
	private List<Form> forms = new ArrayList<Form>();
	
	private AtomicLong generator = new AtomicLong();
	
	public FormServiceImpl() {
		checkBoxs = new ArrayList<CheckBox>();
		checkBoxs.add(new CheckBox("check box1", "check box 1"));
		checkBoxs.add(new CheckBox("check box2", "check box 2"));
		checkBoxs.add(new CheckBox("check box3", "check box 3"));
		
		radios = new ArrayList<Radio>();
		radios.add(new Radio("radio 1", 1));
		radios.add(new Radio("radio 2", 2));
		
		selectMap = new HashMap<Integer, Select>();
		selectMap.put(10000, new Select(10000, "select 0", "10000"));
		selectMap.put(10001, new Select(10001, "select 1", "10001"));
		selectMap.put(10002, new Select(10002, "select 2", "10002"));
		selectMap.put(10003, new Select(10003, "select 3", "10003"));
		selectMap.put(10004, new Select(10004, "select 4", "10004"));
		selectMap.put(10005, new Select(10005, "select 5", "10005"));
	}


	@Override
	public List<CheckBox> getAllCheckBox() {
		
		return checkBoxs;
	}
	
	@Override
	public List<Radio> getAllRadio() {
		return radios;
	}

	@Override
	public Map<Integer, Select> getAllSelect(){
		return selectMap;
	}
	
	@Override
	public void saveForm(Form form) {
		form.setId(generator.incrementAndGet());
		forms.add(form);
	}


	@Override
	public List<Form> getAllForm() {
		
		return forms;
	}


	@Override
	public Form getForm(long id) {
		for(Form form:forms){
			if(id == form.getId()){
				return form;
			}
		}
		return null;
	}


	@Override
	public void updateForm(Form form) {
		for(int i = 0; i < forms.size(); i++){
			Form savedForm = forms.get(i);
			if(form.getId() == savedForm.getId()){
				forms.set(i, form);
			}
		}
		
	}




}
