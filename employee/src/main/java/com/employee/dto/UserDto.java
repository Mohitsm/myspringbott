package com.employee.dto;

import com.employee.entity.Provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private long userId;
	private String name; 
	private String email;
	private String password;
	private String profilePic;
	private String phoneNumber;
	private String role;
	//information
	private boolean enabled=false;
	private boolean emailVerified = false;
	private boolean phoneVerified = false;
	// SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB private Providers provider-Providers.SELF;
	private String providerUserId;
	private Provider provider=Provider.SELF;

}
