package com.mindtree.springboot.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.Entities.Cart;
import com.mindtree.springboot.Entities.CartDetails;
import com.mindtree.springboot.Entities.Product;
import com.mindtree.springboot.exceptionHandling.ServiceException.CartDetailsServiceException;
import com.mindtree.springboot.exceptionHandling.ServiceException.ProductServiceException;
import com.mindtree.springboot.repository.CartDetailsRepository;
import com.mindtree.springboot.services.CartDetailsServices;
import com.mindtree.springboot.services.ProductServices;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class CartDetailsServicesImpl implements CartDetailsServices {
	
	@Autowired
	private CartDetailsRepository cartDetailsRepo;
	
	@Autowired
	private ProductServices prodServ;
	
	@Override
	public List<CartDetails> getCartDetailsList(Optional<Cart> cart) throws  CartDetailsServiceException{
		List<CartDetails> cartList = this.cartDetailsRepo.findByCart(cart);
		if(cartList.isEmpty()){
			throw new CartDetailsServiceException();
		}
		return cartList;
	}

	@Override
	public CartDetails getCartdetailsByProdId(long cartId, long prodId) throws  CartDetailsServiceException{
		
		return null;
	}
	
	public int getCartdetailsIndexByProdId(long prodId, List<CartDetails> cartDetailsList) throws  CartDetailsServiceException{
			CartDetails cartDetailsObj = new CartDetails();
			cartDetailsObj.setProductId(prodId);
			int i = cartDetailsList.indexOf(cartDetailsObj);
			System.out.println("Index of the cart details find by product id is - " + i);
			return i;
	}

	@Override
	public Boolean addCartDetails(CartDetails cartDetails) throws  CartDetailsServiceException{
		try{
			this.cartDetailsRepo.saveAndFlush(cartDetails);
			return true;
		}catch(Exception e){
			throw new CartDetailsServiceException();
		}
			
	}

	@Override
	public CartDetails updateCartDetails(Optional<Cart> cart, CartDetails cartDetails) throws  CartDetailsServiceException, ProductServiceException{
			List<CartDetails> cartDetailsList = this.cartDetailsRepo.findByCart(cart);
			int reqIndex = this.getCartdetailsIndexByProdId(cartDetails.getProductId(), cartDetailsList);
			if(reqIndex == -1){
				CartDetails newCartDetails = new CartDetails();
				cartDetails.setCartDetailsId(newCartDetails.getCartDetailsId());
				Boolean isQuantityValid = this.checkQuantity(cartDetails);
				if(isQuantityValid){
					BeanUtils.copyProperties(cartDetails, newCartDetails);
					System.out.println("Updated cart details object" + newCartDetails);
					try{
						this.cartDetailsRepo.saveAndFlush(newCartDetails);
					}catch(Exception e){
						throw new CartDetailsServiceException();
					}
					return newCartDetails;
				}else {
					throw new CartDetailsServiceException();
				}
			}else{
				CartDetails reqcartD = cartDetailsList.get(reqIndex);
				cartDetails.setCartDetailsId(reqcartD.getCartDetailsId());
				Optional<Product> product = this.prodServ.getProductById(reqcartD.getProductId());
				if(product.isPresent()){
					Boolean isQuantityValid = this.checkQuantity(cartDetails);
					if(isQuantityValid){
						BeanUtils.copyProperties(cartDetails, reqcartD);
						System.out.println("Updated cart details object" + reqcartD);
						try{
							this.cartDetailsRepo.saveAndFlush(reqcartD);
						}catch(Exception e){
							throw new CartDetailsServiceException();
						}
						return reqcartD;
					}else if(cartDetails.getQuantity() == 0){
						try{
							this.cartDetailsRepo.delete(reqcartD);
						}catch(Exception e){
							throw new CartDetailsServiceException();
						}
						return reqcartD;
					} else{
						throw new CartDetailsServiceException();
					}
				}else {
					throw new ProductServiceException();
				}
			}
	}
	
	private Boolean checkQuantity(CartDetails cartD) {
		Boolean isQuantityValid = false;
		if(cartD.getQuantity() > 0){
			isQuantityValid = true;
		}
		return isQuantityValid;
	}

}
