package com.application.user;

public interface UserService {
	
	void saveOrUpdate(UserEntity user);
	
	UserEntity findUser(String username);
	
	void deleteUser(int id);

}
