package com.varsha.springdata.product.repose;

import org.springframework.data.repository.CrudRepository;

import com.varsha.springdata.product.entities.Product;

public interface ProductRespository extends CrudRepository<Product, Integer> {

}
