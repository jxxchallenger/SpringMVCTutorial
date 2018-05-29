package app04b.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app02a.form.ProductForm;
import app04b.domain.Product;
import app04b.service.ProductService;

@Controller(value="ProductController04b")
@RequestMapping(value="/app04b")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("producta")
	public Product addProduct(){
		Product producta = new Product();
		producta.setId(0);
		producta.setName("product abc");
		producta.setDescription("add by @ModelAttribute");
		producta.setPrice(10000.0f);
		return producta;
	}
	
	@RequestMapping(value="/product_input")
	public String inputProduct(){
		LOGGER.info("inputProduct called");
		return "app04b/ProductForm";
	}
	
	@RequestMapping(value="/product_save", method=RequestMethod.POST)
	public String saveProduct(ProductForm form, RedirectAttributes redirectAttributes){
		Product product = new Product();
		
		product.setName(form.getName());
		product.setDescription(form.getDescription());
		try{
			product.setPrice(Float.parseFloat(form.getPrice()));
		}
		catch(NumberFormatException e){
			
		}
		Product saveProduct = productService.addProduct(product);
		
		redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
		
		
		return "redirect:/app04b/product_view/" + saveProduct.getId();
	}
	
	@RequestMapping(value="/product_view/{id}")
	public String viewProduct(@PathVariable long id, Model model){
		Product product = productService.get(id);
		model.addAttribute("product", product);
		
		return "app04b/ProductView";
	}
}
