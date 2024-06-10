package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
