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
@Table(name = "Family_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familyDetailsId;
	private String relationType;
	private String name;
	private String phoneNo;
	private String dataOfBirth;
	
	

}
