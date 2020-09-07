package com.mindtree.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.Entities.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
	
	@Query("from ProductDetails pd where pd.prod=:prodReq")
	public ProductDetails findByProduct(@Param("prodReq") Optional<Product> prodReq);
	
	@Query("from ProductDetails pd where pd.prod=:prodReq")
	public void deleteByProduct(@Param("prodReq") Optional<Product> prodReq);

}
