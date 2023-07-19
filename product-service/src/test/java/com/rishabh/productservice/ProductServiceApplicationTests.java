package com.rishabh.productservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rishabh.productservice.dto.ProductRequest;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Container
	private static MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0")
			.withDatabaseName("projectDB")
			.withUsername("hbstudent").withPassword("hbstudent");
	
	
	@DynamicPropertySource
	public static void overrideProps(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", container::getJdbcUrl);
	}
	
	
	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest product = getProductRequest();
		String requestedProductString = objectMapper.writeValueAsString(product);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestedProductString))
				.andExpect(status().isCreated());
	}
	
	private ProductRequest getProductRequest() {
		return new ProductRequest("iphone 13", "latest iphone 128gb", 69999);
	}

}
