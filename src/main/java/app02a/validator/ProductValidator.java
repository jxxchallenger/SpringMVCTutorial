package app02a.validator;

import java.util.ArrayList;
import java.util.List;

import app02a.form.ProductForm;

public class ProductValidator {
	
	public List<String> validate(ProductForm form){
		List<String> errors = new ArrayList<String>();
		String name = form.getName();
		if(name == null || name.trim().isEmpty()){
			errors.add("Product must have a name");
		}
		String price = form.getPrice();
		if(price == null || price.trim().isEmpty()){
			errors.add("Product must have a price");
		}
		else{
			try{
				Float.parseFloat(form.getPrice());
			}
			catch(NumberFormatException e){
				errors.add("Invalid price value");
			}
		}
		return errors;
	}
}
