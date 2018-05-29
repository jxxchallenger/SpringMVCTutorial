package app07b.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app07b.domain.Product;

@Controller(value="productControllerapp07b")
@RequestMapping("/app07b")
public class ProductController {

	@RequestMapping("/product_input")
	public String inputProduct(Model model){
		model.addAttribute("product", new Product());
		return "app07b/ProductForm";
	}
	
	@RequestMapping(value="/product_save", method=RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "app07b/ProductForm";
		}
		model.addAttribute("product", product);
		return "app07b/ProductDetails";
	}
}
