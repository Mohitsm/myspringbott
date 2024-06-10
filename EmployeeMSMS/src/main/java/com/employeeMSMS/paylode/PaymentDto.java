package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	private Integer paymentId;
	private String inHand;
	private String salaries;
	private String expenses;

}
