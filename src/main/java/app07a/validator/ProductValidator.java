package app07a.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app07a.domain.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
		Float price = product.getPrice();
		if(price != null && price <0){
			errors.rejectValue("price", "price.negative");
		}
		Date productionDate = product.getProductionDate();
		
		if(productionDate != null){
			if(productionDate.after(new Date())){
				System.out.println("salah lagi");
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}

	}

}
