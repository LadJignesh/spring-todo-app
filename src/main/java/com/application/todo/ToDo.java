package com.application.todo;

import java.util.Date;

import javax.validation.constraints.Size;

public class ToDo {
	
	private Integer id;
	private Integer userId;
	
	@Size(min=2, message = "Task should have atleast 2 characters!")
	private String task;
	
	@Size(min=2, message = "Task should have atleasr t characters!")
	private String description;
	
	private Date lastUpdate;
	private boolean isTaskCompleted;
	
	protected ToDo() {
		
	}
	
	public ToDo(Integer id, Integer userId,
			String task, String description, Date lastUpdate,
			boolean isTaskCompleted) {
		super();
		this.id = id;
		this.userId = userId;
		this.task = task;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.isTaskCompleted = isTaskCompleted;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public boolean isTaskCompleted() {
		return isTaskCompleted;
	}
	public void setTaskCompleted(boolean isTaskCompleted) {
		this.isTaskCompleted = isTaskCompleted;
	}
	
	
	
	

}
