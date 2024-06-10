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
@Table(name = "Advance_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advanceDetailsId;
	private String uanNo;
	private String aadharNumber;
	private String ipNumber;
	private String esicNumber;
	private String insuranceNumber;
	private String pfNumber;
	private String panNumber;
	private String drivingLicenceNo;
	private String ctcMontlyI;
	private String probationPeriod;
	private String ctcMontlyA;
	private String clientName;
	private String clientId;
	private String deliveryType;
	private String deliverySubType;
	
	
	

}
