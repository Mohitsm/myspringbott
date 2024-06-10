package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeMSMS.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer>{
long countByGender(String gender);

}
