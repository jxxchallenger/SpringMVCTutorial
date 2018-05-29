package app04b.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import app04b.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products = new HashMap<Long, Product>();
	
	private AtomicLong generator = new AtomicLong();
	
	@Override
	public Product addProduct(Product product) {
		long newId = generator.incrementAndGet();
		product.setId(newId);
		products.put(newId, product);
		
		return product;
	}

	@Override
	public Product get(long id) {
		
		return products.get(id);
	}

}
