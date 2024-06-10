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
@Table(name = "Basic_Details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BasicDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer basicDetailsId;
	private String bloodGroup;
	private String fatherName;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String officialEmailId;
	private String motherName;
	private String status;
	private String gender;
	private String employeeCode;
	private String mobileNumber;
	private String offcialMobileNumber;
	private String joiningDate;
	private String dateOfBirth;
	private String maritalStatus;
	
	

}
