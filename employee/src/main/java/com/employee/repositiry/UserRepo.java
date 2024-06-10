package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
