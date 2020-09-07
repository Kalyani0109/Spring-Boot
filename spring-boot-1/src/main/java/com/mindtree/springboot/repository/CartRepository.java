package com.mindtree.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("from Cart c where c.user=:userReq")
	public Optional<Cart> findByUser (@Param("userReq") Optional<User> userReq);

}
