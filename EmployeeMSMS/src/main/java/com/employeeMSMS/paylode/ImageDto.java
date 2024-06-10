package com.employeeMSMS.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
	
	private Integer imageId;
	private String name;
	private String email;
	private String password;
	private String salary;
	private String address;
	private String category;

}
