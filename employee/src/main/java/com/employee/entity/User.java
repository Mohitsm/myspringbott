package com.employee.entity;





import com.employee.entity.Provider;



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
@Table(name = "USER")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
