//package com.employee.entity;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
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
//	@Getter(value = AccessLevel.NONE)
//	private String password;
//	private String profilePic;
//	private String phoneNumber;
//	private String role;
//	//information
//	@Getter(value = AccessLevel.NONE)
//	private boolean enabled=true;
//	private boolean emailVerified = false;
//	private boolean phoneVerified = false;
//	// SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB private Providers provider-Providers.SELF;
//	private String providerUserId;
//	private Provider provider=Provider.SELF;
//	
//	@ElementCollection(fetch = FetchType.EAGER)
//	private List<String> roleList=new ArrayList<>();
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		Collection<SimpleGrantedAuthority> roles=roleList.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
//		return roles;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.email;
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
//	        return this.enabled;
//	    }
//		@Override
//		public String getPassword() {
//			// TODO Auto-generated method stub
//			return this.password;
//		}
//
//	
//
//}
