package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeMSMS.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
