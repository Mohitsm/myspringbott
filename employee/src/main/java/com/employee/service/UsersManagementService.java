//package com.employee.service;
//
//
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.employee.dto.ReqRep;
//import com.employee.entity.Users;
//import com.employee.repositiry.UsersRepo;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UsersManagementService {
//
//    @Autowired
//    private UsersRepo usersRepo;
//    @Autowired
//    private JWTUtils jwtUtils;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public ReqRep register(ReqRep registrationRequest){
//        ReqRep resp = new ReqRep();
//
//        try {
//            Users ourUser = new Users();
//            ourUser.setEmail(registrationRequest.getEmail());
//            ourUser.setPhoneNumber(registrationRequest.getPhoneNumber());
//            ourUser.setRole(registrationRequest.getRole());
//            ourUser.setName(registrationRequest.getName());
//            ourUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
//            Users ourUsersResult = usersRepo.save(ourUser);
//            if (ourUsersResult.getUsersId()>0) {
//                resp.setUsers((ourUsersResult));
//                resp.setMassage("User Saved Successfully");
//                resp.setStatusCode(200);
//            }
//
//        }catch (Exception e){
//            resp.setStatusCode(500);
//            resp.setError(e.getMessage());
//        }
//        return resp;
//    }
//
//
//    public ReqRep login(ReqRep loginRequest){
//        ReqRep response = new ReqRep();
//        try {
//            authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
//                            loginRequest.getPassword()));
//            var user = usersRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
//            var jwt = jwtUtils.generateToken(user);
//            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
//            response.setStatusCode(200);
//            response.setToken(jwt);
//            response.setRole(user.getRole());
//            response.setRefreshToken(refreshToken);
//            response.setExpirationTime("24Hrs");
//            response.setMassage("Successfully Logged In");
//
//        }catch (Exception e){
//            response.setStatusCode(500);
//            response.setMassage(e.getMessage());
//        }
//        return response;
//    }
//
//
//
//
//
//    public ReqRep refreshToken(ReqRep refreshTokenReqiest){
//        ReqRep response = new ReqRep();
//        try{
//            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
//            Users users = usersRepo.findByEmail(ourEmail).orElseThrow();
//            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
//                var jwt = jwtUtils.generateToken(users);
//                response.setStatusCode(200);
//                response.setToken(jwt);
//                response.setRefreshToken(refreshTokenReqiest.getToken());
//                response.setExpirationTime("24Hr");
//                response.setMassage("Successfully Refreshed Token");
//            }
//            response.setStatusCode(200);
//            return response;
//
//        }catch (Exception e){
//            response.setStatusCode(500);
//            response.setMassage(e.getMessage());
//            return response;
//        }
//    }
//
//
//    public ReqRep getAllUsers() {
//        ReqRep reqRes = new ReqRep();
//
//        try {
//            List<Users> result = usersRepo.findAll();
//            if (!result.isEmpty()) {
//                reqRes.setUsersList(result);
//                reqRes.setStatusCode(200);
//                reqRes.setMassage("Successful");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMassage("No users found");
//            }
//            return reqRes;
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMassage("Error occurred: " + e.getMessage());
//            return reqRes;
//        }
//    }
//
//
//    public ReqRep getUsersById(Long usersId) {
//        ReqRep reqRes = new ReqRep();
//        try {
//            Users usersById = usersRepo.findById(usersId).orElseThrow(() -> new RuntimeException("User Not found"));
//            reqRes.setUsers(usersById);
//            reqRes.setStatusCode(200);
//            reqRes.setMassage("Users with id '" + usersId + "' found successfully");
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMassage("Error occurred: " + e.getMessage());
//        }
//        return reqRes;
//    }
//
//
//    public ReqRep deleteUser(Long usersId) {
//        ReqRep reqRes = new ReqRep();
//        try {
//            Optional<Users> userOptional = usersRepo.findById(usersId);
//            if (userOptional.isPresent()) {
//                usersRepo.deleteById(usersId);
//                reqRes.setStatusCode(200);
//                reqRes.setMassage("User deleted successfully");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMassage("User not found for deletion");
//            }
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMassage("Error occurred while deleting user: " + e.getMessage());
//        }
//        return reqRes;
//    }
//
//    public ReqRep updateUser(Long usersId, Users updatedUser) {
//        ReqRep reqRes = new ReqRep();
//        try {
//            Optional<Users> userOptional = usersRepo.findById(usersId);
//            if (userOptional.isPresent()) {
//                Users existingUser = userOptional.get();
//                existingUser.setEmail(updatedUser.getEmail());
//                existingUser.setName(updatedUser.getName());
//                existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
//                existingUser.setRole(updatedUser.getRole());
//
//                // Check if password is present in the request
//                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
//                    // Encode the password and update it
//                    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//                }
//
//                Users savedUser = usersRepo.save(existingUser);
//                reqRes.setUsers(savedUser);
//                reqRes.setStatusCode(200);
//                reqRes.setMassage("User updated successfully");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMassage("User not found for update");
//            }
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMassage("Error occurred while updating user: " + e.getMessage());
//        }
//        return reqRes;
//    }
//
//
//    public ReqRep getMyInfo(String email){
//        ReqRep reqRes = new ReqRep();
//        try {
//            Optional<Users> userOptional = usersRepo.findByEmail(email);
//            if (userOptional.isPresent()) {
//                reqRes.setUsers(userOptional.get());
//                reqRes.setStatusCode(200);
//                reqRes.setMassage("successful");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMassage("User not found for update");
//            }
//
//        }catch (Exception e){
//            reqRes.setStatusCode(500);
//            reqRes.setMassage("Error occurred while getting user info: " + e.getMessage());
//        }
//        return reqRes;
//
//    }
//}
