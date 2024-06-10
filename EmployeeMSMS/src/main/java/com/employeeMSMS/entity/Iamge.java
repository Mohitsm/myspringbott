package com.employeeMSMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Iamge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;
	private String name;
	private String email;
	private String password;
	private String salary;
	private String address;
	private String category;

}
