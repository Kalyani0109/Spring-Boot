package com.mindtree.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.springboot.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
