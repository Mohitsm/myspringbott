package com.employeeMSMS.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.paylode.TaskDto;
import com.employeeMSMS.repositry.TaskRepo;
import com.employeeMSMS.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TaskDto createTask(TaskDto taskDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDto updateTask(TaskDto taskDto, Integer taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(Integer taskId) {
		// TODO Auto-generated method stub

	}

	@Override
	public TaskDto getTaskBYid(Integer taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDto> getAllTask() {
		// TODO Auto-generated method stub
		return null;
	}

}
