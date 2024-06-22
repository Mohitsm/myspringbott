package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendances")
public class Attendance {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attendanceId;
	private String name;
	private String userName;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "employee_Id")
	private Employee employee;

}
