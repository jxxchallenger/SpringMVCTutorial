package app04b.service;

import app04b.domain.Product;

public interface ProductService {

	Product addProduct(Product product);
	
	Product get(long id);
	
}
