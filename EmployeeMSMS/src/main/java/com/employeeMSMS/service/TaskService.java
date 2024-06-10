package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.TaskDto;

public interface TaskService {
	TaskDto createTask(TaskDto taskDto);
	TaskDto updateTask(TaskDto taskDto,Integer taskId);
	void deleteTask(Integer taskId);
	TaskDto getTaskBYid(Integer taskId);
	List<TaskDto> getAllTask();
	

}
