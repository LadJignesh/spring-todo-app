package com.application.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service(value="toDoService")
public class ToDoServiceImpl implements ToDoService{
	
	private static List<ToDo> tasks = new ArrayList<>();
	
	private static int taskCount = 3;
	
	static {
		tasks.add(new ToDo(1, 2, "Wash Clothes", "Wash clothes at 10:00 am", new Date(), false));
		tasks.add(new ToDo(2, 2, "Wash Dishes", "Wash dishes at 10:00 am", new Date(), false));
		tasks.add(new ToDo(3, 1, "Go for grocery shopping", "Go shopping at 10:00 am", new Date(), true));
	}

	@Override
	public List<ToDo> getAllTasks(int userId) {
		List<ToDo> userTasks = new ArrayList<>();
		
		for (ToDo task: tasks) {
			if(task.getUserId() == userId) {
				userTasks.add(task);
			}
		}
		
		return userTasks;
	}

	@Override
	public void createTask(ToDo task) {
		if(task.getId() == null) {
			task.setId(++taskCount);
		}
		
		tasks.add(task);
	}

	@Override
	public void updateTask(ToDo taskUpdate) {
		for(ToDo task: tasks) {
			if(taskUpdate.getId() == task.getId()) {
				BeanUtils.copyProperties(taskUpdate, task);
			}
		}		
	}

	@Override
	public void removeRask(int taskId) {
		for(ToDo task: tasks) {
			if(task.getId() == taskId) {
				tasks.remove(taskId);
			}
		}
	}
	
}
