package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Notification;




public interface NotificationRepo extends JpaRepository<Notification, Long>{

}
