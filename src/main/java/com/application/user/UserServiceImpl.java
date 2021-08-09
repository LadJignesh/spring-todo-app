package com.application.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public void saveOrUpdate(UserEntity user) {
		userRepository.save(user);
	}
	
	public UserEntity findUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteUser(int id)   
	{  
		userRepository.deleteById(id);  
	}  

}
