package com.mindtree.springboot.dto;

import java.util.List;

public class CartDetailsDTO {
	
	private long userId;
	
	private long cartId;
	
	private long totalAmountPending;
	
	List<CartDetailsProdList> cartProdList;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<CartDetailsProdList> getCartProdList() {
		return cartProdList;
	}

	public void setCartProdList(List<CartDetailsProdList> cartProdList) {
		this.cartProdList = cartProdList;
	}

	public long getTotalAmountPending() {
		return totalAmountPending;
	}

	public void setTotalAmountPending(long totalAmountPending) {
		this.totalAmountPending = totalAmountPending;
	}
	
}
