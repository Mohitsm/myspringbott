package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Notification;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.NotificationDto;
import com.employee.repositiry.NotificationRepo;
import com.employee.service.NotificationService;
@Service
public class NotificationServiceImp implements NotificationService {
	
	@Autowired
	private NotificationRepo notificationRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public NotificationDto createNotification(NotificationDto notificationDto) {
		// TODO Auto-generated method stub
		Notification notification=this.modelMapper.map(notificationDto, Notification.class);
		Notification createNotification=this.notificationRepo.save(notification);
		return this.modelMapper.map(createNotification, NotificationDto.class);
	}

	@Override
	public NotificationDto updateNotification(NotificationDto notificationDto, Long notificationId) {
		// TODO Auto-generated method stub
		Notification notification=this.notificationRepo.findById(notificationId).orElseThrow(()-> new ResourceNotFoundException("Notification", "Id", notificationId));
		notification.setName(notificationDto.getName());
		notification.setUsername(notificationDto.getUsername());
		notification.setEmail(notificationDto.getEmail());
		Notification updateNotification=this.notificationRepo.save(notification);
		return this.modelMapper.map(updateNotification,NotificationDto.class);
	}

	@Override
	public void deleteNotification(Long notificationId) {
		// TODO Auto-generated method stub
		Notification notification=this.notificationRepo.findById(notificationId).orElseThrow(()-> new ResourceNotFoundException("Notification", "Id", notificationId));

		this.notificationRepo.delete(notification);
		
	}

	@Override
	public NotificationDto getNotificationId(Long notificationId) {
		// TODO Auto-generated method stub
		Notification notification=this.notificationRepo.findById(notificationId).orElseThrow(()-> new ResourceNotFoundException("Notification", "Id", notificationId));

		
		return this.modelMapper.map(notification, NotificationDto.class);
	}

	@Override
	public List<NotificationDto> getAllNotification() {
		// TODO Auto-generated method stub
		List<Notification> notifications=this.notificationRepo.findAll();
		List<NotificationDto> notificationDtos=notifications.stream().map((no)->this.modelMapper.map(no, NotificationDto.class)).collect(Collectors.toList());
		
		return notificationDtos;
	}

}
