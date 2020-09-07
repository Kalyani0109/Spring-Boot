package com.mindtree.springboot.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.User;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartServiceException;
import com.mindtree.springboot.repository.CartRepository;
import com.mindtree.springboot.services.CartServices;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class CartServicesImpl implements CartServices {

	@Autowired
	private CartRepository cartResp;
	
	@Override
	public Optional<Cart> getCartInfo(Optional<User> userReq) throws CartServiceException {
		Optional<Cart> cartObj = this.cartResp.findByUser(userReq);
		if(!cartObj.isPresent()){
			throw new CartServiceException();
		}
		return cartObj;
	}

	@Override
	public Boolean addCart(Cart cart) throws CartServiceException{
		try{
			this.cartResp.saveAndFlush(cart);
			return true;
		}catch(Exception e){
			throw new CartServiceException();
		}
			
	}

}
