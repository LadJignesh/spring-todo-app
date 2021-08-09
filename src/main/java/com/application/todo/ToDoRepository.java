package com.application.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<TaskEntity, Integer> {
	
	List<TaskEntity> findAllTasksByUserId(int userId);

}
