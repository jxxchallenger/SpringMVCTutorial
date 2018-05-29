package app05a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app05a.domain.Form;
import app05a.srevice.FormService;

@Controller
@RequestMapping("/app05a")
public class FormTabController {

	@Autowired
	private FormService formService;
	
	@RequestMapping("/form_input")
	public String inputForm(Model model){
		model.addAttribute("checklist", formService.getAllCheckBox());
		model.addAttribute("radioList", formService.getAllRadio());
		model.addAttribute("selectMap", formService.getAllSelect());
		model.addAttribute("form", new Form());
		
		return "app05a/FormInput";
	}
	
	@RequestMapping(value="/form_edit/{id}")
	public String editForm(Model model, @PathVariable long id){
		model.addAttribute("checklist", formService.getAllCheckBox());
		model.addAttribute("radioList", formService.getAllRadio());
		model.addAttribute("selectMap", formService.getAllSelect());
		model.addAttribute("form", formService.getForm(id));
		
		return "app05a/FormEdit";
	}
	
	@RequestMapping(value="/form_save", method=RequestMethod.POST)
	public String saveForm(Form form){
		formService.saveForm(form);
		return "redirect:/app05a/form_view";
	}
	
	@RequestMapping(value="/form_update", method=RequestMethod.POST)
	public String updateForm(Form form){
		formService.updateForm(form);
		
		return "redirect:/app05a/form_view";
	}
	
	@RequestMapping("/form_view")
	public String viewForm(Model model){
		model.addAttribute("formList", formService.getAllForm());
		return "app05a/FormList";
	}
}
