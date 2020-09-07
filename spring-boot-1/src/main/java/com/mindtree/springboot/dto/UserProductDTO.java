package com.mindtree.springboot.dto;

public class UserProductDTO {
	
	private long userId;
	
	private CartDetailsProdList cartProdList;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public CartDetailsProdList getCartProdList() {
		return cartProdList;
	}

	public void setCartProdList(CartDetailsProdList cartProdList) {
		this.cartProdList = cartProdList;
	}


}
