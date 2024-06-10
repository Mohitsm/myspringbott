package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdvanceDetailsDto {
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
