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
	public List<TaskEntity> getToDoTask(@PathVariable int userId) {
		return toDoService.getAllTasks(userId);
	}
	
	@PostMapping(path = "/todo/{userId}")
	public void createTask(@Valid @RequestBody TaskEntity todoTask, @PathVariable int userId) throws Exception {
		if(todoTask.getUserId() != userId) {
			throw new Exception("Task cannot be created");
		}
		
		toDoService.createTask(todoTask);
		
	}
	
	@PutMapping(path = "/todo/{userId}")
	public String updateTask(@Valid @RequestBody TaskEntity todoTask, @PathVariable int userId) {
		toDoService.createTask(todoTask);
		return "redirect:/todo/" + userId;
	}
	
	@DeleteMapping(path = "/todo/{taskId}")
	public void deleteTask(@PathVariable int taskId) {
		toDoService.removeTask(taskId);
	}
}
