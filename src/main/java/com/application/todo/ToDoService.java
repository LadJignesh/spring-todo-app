package com.application.todo;

import java.util.ArrayList;
import java.util.List;

public interface ToDoService {
	
	List<TaskEntity> getAllTasks(int userId);
	
	void createTask(TaskEntity task);
	
	void removeTask(int taskId);
}
