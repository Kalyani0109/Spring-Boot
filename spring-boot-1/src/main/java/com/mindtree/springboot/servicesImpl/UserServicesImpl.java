package com.mindtree.springboot.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.Entities.User;
import com.mindtree.springboot.exceptionHandling.ServiceException.UserServiceException;
import com.mindtree.springboot.repository.UserRepository;
import com.mindtree.springboot.services.UserServices;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Optional<User> getUser(long userID) throws UserServiceException {
			Optional<User> userResp = this.userRepo.findById(userID);
			System.out.println("User Response" + userResp);
			if(!userResp.isPresent()){
				throw new UserServiceException();
			}
			return userResp;
	}

	@Override
	public List<User> getAllUserList() throws UserServiceException{
			List<User> userList = this.userRepo.findAll();
			if(userList.isEmpty()){
				throw new UserServiceException();
			}
			return userList;
	}

	@Override
	public Boolean addUser(User user) throws UserServiceException{
			this.userRepo.saveAndFlush(user);
			return true;
	}

}
