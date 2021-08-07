package com.application.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user  = userService.findOne(id);
		if(null == user) {
			throw new UserNotFoundException("id- "+ id);
		}
		return user;
	}
	
		@PostMapping(path = "/users")
		public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
			User savedUser = userService.save(user);
			
			URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
			
			return ResponseEntity.created(location).build();
			
		}

}
