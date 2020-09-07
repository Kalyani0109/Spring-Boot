package com.mindtree.springboot.services;

import java.util.List;
import java.util.Optional;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.CartDetails;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;

public interface CartDetailsServices {
	
	public Boolean addCartDetails(CartDetails cartDetails) throws CartDetailsServiceException;
	
	public CartDetails getCartdetailsByProdId(long cartId, long prodId) throws CartDetailsServiceException;
	
	public CartDetails updateCartDetails(Optional<Cart> cart, CartDetails cartDetails) throws CartDetailsServiceException, ProductServiceException;
	
	public List<CartDetails> getCartDetailsList (Optional<Cart> cart) throws CartDetailsServiceException;

}
