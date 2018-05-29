package app02a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app02a.domain.Product;
import app02a.form.ProductForm;
import app02a.validator.ProductValidator;

public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ProductForm form = new ProductForm();
		form.setName(request.getParameter("name"));
		form.setDescription(request.getParameter("description"));
		form.setPrice(request.getParameter("price"));
		
		ProductValidator validator = new ProductValidator();
		List<String> errors = validator.validate(form);
		if(errors.isEmpty()){
			Product product = new Product();
			
			product.setName(form.getName());
			product.setDescription(form.getDescription());
			product.setPrice(Float.parseFloat(form.getPrice()));

			
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/ch02/ProductDetials.jsp";
		}
		else{
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "/WEB-INF/jsp/ch02/ProductForm.jsp";
		}
		
		
	}

}
