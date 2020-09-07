package com.mindtree.springboot.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public User () {
		this.userId = 101L;
		this.firstName = "kalyani";
		this.lastName = "sharma";
	}
	
	public User (long id, String firstName, String lastName) {
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "user id = " +this.userId + "first name = "+ this.firstName + "last name = " + this.lastName;
	}
	

}
