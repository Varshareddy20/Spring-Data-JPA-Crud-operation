package com.varsha.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

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
		Product product = (Product) repository.findById(1).get();
		assertNotNull(product);
		assertEquals("oppo", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDescription());
	}
	@Test
	public void testUpdate() {
		Product product = (Product) repository.findById(3).get();
		product.setPrice(1200d);
		repository.save(product);
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(3);
	}
	
	@Test
	public void testFindByName(){
		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));
	
	}
	
	@Test
	public void testFindByNameAndDescription(){
		List<Product> products = repository.findByNameAndDescription("TV","From Sony Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan(){
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescriptionContains(){
		List<Product> products = repository.findByDescriptionContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByPriceBetween(){
		List<Product> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescriptionLike(){
		List<Product> products = repository.findByDescriptionLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByIdsIn() {
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3));
		products.forEach(p -> System.out.println(p.getName()));
	}
}
