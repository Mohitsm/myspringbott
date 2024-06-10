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
public class Excel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer excelId;
	private String productName;
	private String productDesc;
	private String productPrice;

}
