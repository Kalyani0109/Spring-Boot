package com.mindtree.springboot.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cartDetailsId;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="quantity")
	private long quantity;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getCartDetailsId() {
		return cartDetailsId;
	}

	public void setCartDetailsId(long cartDetailsId) {
		this.cartDetailsId = cartDetailsId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public boolean equals(Object obj) {
		CartDetails compareObj = (CartDetails) obj;
		if(this == obj){
			return true;
		}else if(obj == null){
			return false;
		}else if(this.productId == compareObj.getProductId()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		
		return "Cart Details id = " + this.cartDetailsId + "Product Id - " + this.productId + "Quantity" + this.quantity + "Cart = " + this.cart;
	}
	
	
	
}