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
@Table(name = "Bank_Details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankDetailsId;
	private String accountHolderName;
	private String accountNo;
	private String ifscCode;
	private String bankName;
	private String branchAddress;
	

}
