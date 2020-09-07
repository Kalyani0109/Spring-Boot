package com.mindtree.springboot.services;

import java.util.Optional;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.User;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartServiceException;

public interface CartServices {
	
	public Boolean addCart(Cart cart) throws CartServiceException;
	
	public Optional<Cart> getCartInfo(Optional<User> user) throws CartServiceException;
	

}
