package com.varsha.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.varsha.springdata.product.entities.Product;
import com.varsha.springdata.product.repose.ProductRespository;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	ProductRespository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {

		Product product = new Product();
		product.setId(3);
		product.setName("one plus");
		product.setDescription("good");
		product.setPrice(1050d);
		
		repository.save(product);
	}
	@Test
	public void testRead() {
		Product product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("oppo", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDescription());
	}
	@Test
	public void testUpdate() {
		Product product = repository.findById(3).get();
		product.setPrice(1200d);
		repository.save(product);
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(3);
	}
}
