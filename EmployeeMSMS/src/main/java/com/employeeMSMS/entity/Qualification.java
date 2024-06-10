package com.employeeMSMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Qualification")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qualificationId;
	private String degree;

}
