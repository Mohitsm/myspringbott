package com.employee.entity;




import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String name;
	private String zName;
	private String email;
	private String mobile;
	private String dob;
	private String password;
	private String fname;
	private Double salary;
	private String address;
	private String jod;
	private String gender;
	private String category;
	private String marritalStatus;
	private String status;
	private String site;
	private String work;
	private String zmageName;
	
	
	
	
//	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<AddPayment> addPayments=new ArrayList<>();
//	
//	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<Attendance> attendances=new ArrayList<>();
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CalculateSalary>calculateSalaries=new ArrayList<>();
	
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private PayEmployee payEmployee;
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Report>reports=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Setting>settings=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Notification>notifications=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Document>documents=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Attendance> attendances=new ArrayList<>();
	
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private AddPayment addPayment;
	
	
	
	
	

}
