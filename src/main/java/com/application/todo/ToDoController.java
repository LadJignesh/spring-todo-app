package com.application.todo;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;

	
	@GetMapping(path = "/todo/{userId}")
	public List<ToDo> getToDoTask(@PathVariable int userId) {
		return toDoService.getAllTasks(userId);
	}
	
	@PostMapping(path = "/todo/{userId}")
	public ResponseEntity<Object> createTask(@Valid @RequestBody ToDo todoTask, @PathVariable int userId) throws Exception {
		if(todoTask.getUserId() != userId) {
			throw new Exception("Task cannot be created");
		}
		
		toDoService.createTask(todoTask);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.buildAndExpand(userId)
				.toUri();
		System.out.println(ResponseEntity.created(location).build());
			
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/todo/{userId}")
	public String updateTask(@Valid @RequestBody ToDo todoTask, @PathVariable int userId) {
		toDoService.updateTask(todoTask);
		return "redirect:/todo/" + userId;
	}
	
	@DeleteMapping(path = "/todo/{userId}")
	public String deleteTask(@PathVariable int userId) {
		toDoService.removeRask(userId);
		return "redirect:/todo/" + userId;
	}
}
