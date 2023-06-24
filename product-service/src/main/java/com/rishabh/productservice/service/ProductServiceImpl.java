package com.rishabh.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.productservice.dto.ProductRequest;
import com.rishabh.productservice.dto.ProductResponse;
import com.rishabh.productservice.model.Product;
import com.rishabh.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		
		productRepository.save(product);	
		
	}

	public List<ProductResponse> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list = (List<Product>) productRepository.findAll();
		return list.stream().map(product -> mapToProductResponse(product)).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
	
}
