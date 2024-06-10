package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDetailsDto {
	private Integer familyDetailsId;
	private String relationType;
	private String name;
	private String phoneNo;
	private String dataOfBirth;

}
