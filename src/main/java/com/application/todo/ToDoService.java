package com.application.todo;

import java.util.ArrayList;
import java.util.List;

public interface ToDoService {
	
	List<ToDo> getAllTasks(int userId);
	
	void createTask(ToDo task);
	
	void updateTask(ToDo task);
	
	void removeRask(int taskId);
}
