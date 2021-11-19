package com.lti.SmartShop.service;

import org.springframework.data.repository.CrudRepository;

import com.lti.SmartShop.model.Product;

public interface ProductService extends CrudRepository<Product, Integer> {
}