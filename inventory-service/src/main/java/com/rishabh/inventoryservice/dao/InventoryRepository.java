package com.rishabh.inventoryservice.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.inventoryservice.entity.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
	
	Optional<Inventory> findBySkuCode(String skuCode);
	
}
