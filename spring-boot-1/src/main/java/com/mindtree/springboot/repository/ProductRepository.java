package com.mindtree.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.springboot.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
