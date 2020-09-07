package com.mindtree.springboot.services;

import java.util.List;
import java.util.Optional;

import com.mindtree.springboot.Entities.User;
import com.mindtree.springboot.exceptionHandling.ServiceException.UserServiceException;

public interface UserServices {
	
	public Boolean addUser(User user) throws UserServiceException;
	
	public Optional<User> getUser( long userID) throws UserServiceException;
	
	public List<User> getAllUserList () throws UserServiceException;

}
