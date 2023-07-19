package com.rishabh.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.inventoryservice.dao.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Transactional
	public boolean checkstock(String skuCode) {
		return inventoryRepository.findBySkuCode(skuCode).isPresent();
	}

}
