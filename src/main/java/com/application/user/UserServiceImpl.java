package com.application.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", "password"));
		users.add(new User(2, "Jignesh", "password"));
		users.add(new User(3, "Loki","password"));
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

}