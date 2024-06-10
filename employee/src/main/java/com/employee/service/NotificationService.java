package com.employee.service;

import java.util.List;


import com.employee.dto.NotificationDto;

public interface NotificationService {
	NotificationDto createNotification(NotificationDto notificationDto);
	NotificationDto updateNotification(NotificationDto notificationDto,Long notificationId);
	void deleteNotification(Long notificationId);
	NotificationDto getNotificationId(Long notificationId);
	List<NotificationDto> getAllNotification();

}
