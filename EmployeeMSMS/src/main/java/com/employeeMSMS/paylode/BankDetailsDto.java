package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankDetailsDto {
	private Integer bankDetailsId;
	private String accountHolderName;
	private String accountNo;
	private String ifscCode;
	private String bankName;
	private String branchAddress;

}
