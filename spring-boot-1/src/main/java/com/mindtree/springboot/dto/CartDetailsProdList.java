package com.mindtree.springboot.dto;

public class CartDetailsProdList {
	
	private long prodId;
	
	private long quantity;
	
	public CartDetailsProdList () {
		
	}
	
	public CartDetailsProdList(long prodId, long quantity){
		this.prodId = prodId;
		this.quantity = quantity;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	

}
