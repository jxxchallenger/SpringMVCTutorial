package app08a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app08a")
public class ExpressionLanguageController {

	@RequestMapping("/el")
	public String showEL(){
		return "app08a/EL";
	}
}