//package com.employee.serviceImpl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.employee.entity.Users;
//import com.employee.exception.ResourceNotFoundException;
//import com.employee.repositiry.UsersRepo;
//import com.employee.service.UsersService;
//
//@Service
//public class UsersServiceImpl implements UsersService {
//	
//	@Autowired
//	private UsersRepo usersRepo;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public Users saveUsers(Users users) {
//		// TODO Auto-generated method stub
//		
//		users.setPassword(passwordEncoder.encode(users.getPassword()));
//		
//		users.setRole(users.getRole());
//		
//		return usersRepo.save(users);
//	}
//
//	@Override
//	public Optional<Users> getUserById(Long usersId) {
//		// TODO Auto-generated method stub
//		return usersRepo.findById(usersId);
//	}
//
//	@Override
//	public Optional<Users> updateUsers(Users users) {
//		// TODO Auto-generated method stub
//		 Users users2=usersRepo.findById(users.getUsersId()).orElseThrow(()-> new ResourceNotFoundException("Users", "id", users.getUsersId()));
//		 
//		 users2.setName(users.getName());
//		 users2.setEmail(users.getEmail());
//		 users2.setPassword(users.getPassword());
//		 users2.setPhoneNumber(users.getPhoneNumber());
//		 users2.setEmailVerified(users.isEmailVerified());
//		 users2.setEnabled(users.isEnabled());
//		 users2.setProvider(users.getProvider());
//		 users2.setRole(users.getRole());
//		 users2.setProviderUserId(users.getProviderUserId());
//		 
//		 Users users3=usersRepo.save(users2);
//		 return Optional.ofNullable(users3);
//		 
//		 
//		 
//	}
//
//	@Override
//	public void deleteUser(Long usersId) {
//		// TODO Auto-generated method stub
//		 Users users2=usersRepo.findById(usersId).orElseThrow(()-> new ResourceNotFoundException("Users", "id", usersId));
//
//		 usersRepo.delete(users2);
//		
//	}
//
//	@Override
//	public boolean isUsersExist(Long usersId) {
//		// TODO Auto-generated method stub
//		 Users users2=usersRepo.findById(usersId).orElseThrow(null);
//
//		return users2!=null ? true: false;
//	}
//
//	@Override
//	public List<Users> getAllUsers() {
//		// TODO Auto-generated method stub
//		return usersRepo.findAll();
//	}
//
//	@Override
//	public boolean isUserExistByEmail(String email) {
//		// TODO Auto-generated method stub
//		Users users=usersRepo.findByEmail(email).orElseThrow(null);
//		return users!=null?true:false;
//	}
//
//}
