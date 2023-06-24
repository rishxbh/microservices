package com.rishabh.productservice.service;

import java.util.List;

import com.rishabh.productservice.dto.ProductRequest;
import com.rishabh.productservice.dto.ProductResponse;

public interface ProductService {
	void createProduct(ProductRequest productRequest);
	List<ProductResponse> getAllProducts();
}
