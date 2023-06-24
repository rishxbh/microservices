package com.rishabh.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.productservice.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
