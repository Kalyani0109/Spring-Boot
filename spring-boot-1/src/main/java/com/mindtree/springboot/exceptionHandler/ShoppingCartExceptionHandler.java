package com.mindtree.springboot.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springboot.exceptionHandling.ServiceException.CartDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.UserServiceException;

@ControllerAdvice
@RestController
public class ShoppingCartExceptionHandler {
	
	@ExceptionHandler(value=UserServiceException.class)
	public ResponseEntity<String> UserExcpetion (UserServiceException userException) {
		System.out.println(userException.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching User Details");
	}
	
	@ExceptionHandler(value=CartServiceException.class)
	public ResponseEntity<String> CartException (CartServiceException cartException) {
		System.out.println(cartException.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching Cart");
	}
	
	@ExceptionHandler(value=CartDetailsServiceException.class)
	public ResponseEntity<String> CartDetailsException (CartDetailsServiceException cartdetailsException) {
		System.out.println(cartdetailsException.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching details of Cart");
	}
	
	@ExceptionHandler(value=ProductServiceException.class)
	public ResponseEntity<String> ProductException (ProductServiceException ProductException) {
		System.out.println(ProductException.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching Product");
	}
	
	@ExceptionHandler(value=ProductDetailsServiceException.class)
	public ResponseEntity<String> ProductDetailsException (ProductDetailsServiceException ProductDetailsException) {
		System.out.println(ProductDetailsException.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching details of Product");
	}

}
