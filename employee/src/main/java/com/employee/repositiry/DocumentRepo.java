package com.employee.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Document;




public interface DocumentRepo extends JpaRepository<Document, Long> {

}
