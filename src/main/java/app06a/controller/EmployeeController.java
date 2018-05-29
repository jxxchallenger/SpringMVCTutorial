package app06a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app06a.domain.Employee;

@Controller
@RequestMapping("/app06a")
public class EmployeeController {

	@RequestMapping("/employee_input")
	public String inputEmployee(Model model){
		model.addAttribute(new Employee());
		return "app06a/EmployeeForm";
	}
	
	@RequestMapping(value="employee_save", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			//FieldError fieldError = bindingResult.getFieldError();
			return "app06a/EmployeeForm";
		}
		model.addAttribute("employee", employee);
		return "app06a/EmployeeDetails";
	}
}
