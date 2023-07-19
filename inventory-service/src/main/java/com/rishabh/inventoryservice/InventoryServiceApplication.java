package com.rishabh.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rishabh.inventoryservice.dao.InventoryRepository;
import com.rishabh.inventoryservice.entity.Inventory;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory1 = new Inventory();
			Inventory inventory2 = new Inventory();
			
			inventory1.setSkuCode("iphone_13");
			inventory1.setQuantity(46);
			
			inventory2.setSkuCode("iphone_14");
			inventory2.setQuantity(77);
			
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
