package com.varsha.springdata.product.repose;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.varsha.springdata.product.entities.Product;

public interface ProductRespository extends CrudRepository<Product, Long> {

	List<Product>findByName(String name);
	
	List<Product>findByNameAndDescription(String name, String description );
	
	List<Product>findByPriceGreaterThan(Double price);
	
	List<Product>findByDescriptionContains(String Description);

	List<Product>findByPriceBetween(Double price1, Double price2);
	
	List<Product>findByDescriptionLike(String desc);
	
	List<Product>findByIdIn(List<Long> ids);

}