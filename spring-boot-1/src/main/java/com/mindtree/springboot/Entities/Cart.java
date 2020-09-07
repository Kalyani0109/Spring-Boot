package com.mindtree.springboot.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_id")
	private long cartId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional=false)
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "cart id = " + this.cartId + "user = " + this.user;
	}
	
	

}
