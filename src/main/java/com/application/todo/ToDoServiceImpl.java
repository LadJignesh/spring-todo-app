package com.application.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="toDoService")
public class ToDoServiceImpl implements ToDoService{
	
	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public List<TaskEntity> getAllTasks(int userId) {
		return toDoRepository.findAllTasksByUserId(userId);
	}

	@Override
	public void createTask(TaskEntity task) {
		task.setLastUpdated(new Date());
		toDoRepository.save(task);
	}


	@Override
	public void removeTask(int taskId) {
		toDoRepository.deleteById(taskId);
	}
	
}
