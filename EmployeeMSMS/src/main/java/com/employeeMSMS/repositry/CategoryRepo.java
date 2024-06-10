package com.employeeMSMS.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeMSMS.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
