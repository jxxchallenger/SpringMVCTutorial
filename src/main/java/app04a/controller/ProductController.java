package app04a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app02a.domain.Product;
import app02a.form.ProductForm;

@Controller
@RequestMapping(value="/app04a")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value={"/product_input"})
	public String inputProduct(){
		LOGGER.info("inputProduct called");
		return "ch04/ProductForm";
	}
	
	@RequestMapping(value="/product_save", method=RequestMethod.POST)
	public String saveProduct(ProductForm form, Model model){
		Product product = new Product();
		product.setName(form.getName());
		product.setDescription(form.getDescription());
		try{
			product.setPrice(Float.parseFloat(form.getPrice()));
		}
		catch(NumberFormatException e){
			
		}
		model.addAttribute("product", product);
		
		return "ch04/ProductDetials";
	}
}
