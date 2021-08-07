package com.application.user;

public interface UserService {
	
	User save(User user);
	
	User findOne(int id);

}
