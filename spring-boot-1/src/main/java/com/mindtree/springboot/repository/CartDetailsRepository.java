package com.mindtree.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Long> {
	
	@Query("from CartDetails c where c.cart=:cartResp")
	public List<CartDetails> findByCart(@Param("cartResp") Optional<Cart> cartResp);

}
