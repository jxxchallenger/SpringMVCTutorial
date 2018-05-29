package app07a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app07a.domain.Product;
import app07a.validator.ProductValidator;

@Controller("productController07a")
@RequestMapping("/app07a")
public class ProductController {

	@RequestMapping("/product_input")
	public String inputProduct(Model model){
		model.addAttribute("product", new Product());
		return "app07a/ProductForm";
	}
	
	@RequestMapping(value="/product_save", method=RequestMethod.POST)
	public String saveProduct(Product product, BindingResult bindingResult, Model model){
		
		ProductValidator productValidator = new ProductValidator();
		
		productValidator.validate(product, bindingResult);
		
		if(bindingResult.hasErrors()){
			//FieldError fieldError = bindingResult.getFieldError();
			return "app07a/ProductForm";
		}
		
		model.addAttribute("product", product);
		return "app07a/ProductDetails";
	}
}
