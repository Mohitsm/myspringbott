package com.employeeMSMS.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proId;
//	@Lob
//	private List<String> companyName;
//	@Lob
//	private List<String> designation;
//	@Lob
//	private List<String> fromData;
//	@Lob
//	private List<String> toData;
//	@Lob
//	private List<String> duration;
	
//	@Lob
//	private List<PreQ> preQs=new ArrayList<>();
	
	private String companyName;
	private String designation;

	private String fromdata;

	private String toData;

	private String duration;

	
	

}
