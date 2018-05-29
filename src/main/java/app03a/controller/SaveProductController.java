package app03a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import app02a.domain.Product;
import app02a.form.ProductForm;

public class SaveProductController implements Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveProductController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("SaveProductController called");
		ProductForm form = new ProductForm();
		form.setName(request.getParameter("name"));
		form.setDescription(request.getParameter("description"));
		form.setPrice(request.getParameter("price"));
		
		Product product = new Product();
		product.setName(form.getName());
		product.setDescription(form.getDescription());
		try {
			product.setPrice(Float.parseFloat(form.getPrice()));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		return new ModelAndView("ch03a/ProductDetials", "product", product);
	}

}
