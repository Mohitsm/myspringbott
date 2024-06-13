//package com.employee.entity;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "usersDetails")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Users implements UserDetails{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long usersId;
//	private String name; 
//	private String email;
//	private String password;
//	private String profilePic;
//	private String phoneNumber;
//	private String role;
//	//information
//	private boolean enabled=false;
//	private boolean emailVerified = false;
//	private boolean phoneVerified = false;
//	// SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB private Providers provider-Providers.SELF;
//	private String providerUserId;
//	private Provider provider=Provider.SELF;
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return List.of(new SimpleGrantedAuthority(role));
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return email;
//	}
//	
//	 @Override
//	    public boolean isAccountNonExpired() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isAccountNonLocked() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isCredentialsNonExpired() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isEnabled() {
//	        return true;
//	    }
//
//	
//
//}
