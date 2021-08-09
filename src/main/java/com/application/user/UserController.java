package com.application.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping(path = "/user/{username}/{password}")
	public int authenticateUser(@PathVariable String username, @PathVariable String password) {
		UserEntity user  = userService.findUser(username);
		if(null == user) {
			return 0;
		}
		return user.getId();
	}
	
		@PostMapping(path = "/user")
		public int createUser(@Valid @RequestBody UserEntity user) {
			userService.saveOrUpdate(user);
			
			return user.getId();
			
		}
		
		@DeleteMapping("/user/{id}")  
		private void deleteStudent(@PathVariable("id") int id)   
		{  
			userService.deleteUser(id);  
		}  

}
