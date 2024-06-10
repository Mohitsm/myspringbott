package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.employee.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
