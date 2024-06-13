//package com.employee.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import com.employee.dto.ReqRep;
//import com.employee.entity.Users;
//import com.employee.service.UsersManagementService;
//
//@RestController
//public class UserManagementController {
//    @Autowired
//    private UsersManagementService usersManagementService;
//
//    @PostMapping("/auth/register")
//    public ResponseEntity<ReqRep> regeister(@RequestBody ReqRep reg){
//        return ResponseEntity.ok(usersManagementService.register(reg));
//    }
//
//    @PostMapping("/auth/login")
//    public ResponseEntity<ReqRep> login(@RequestBody ReqRep req){
//        return ResponseEntity.ok(usersManagementService.login(req));
//    }
//
//    @PostMapping("/auth/refresh")
//    public ResponseEntity<ReqRep> refreshToken(@RequestBody ReqRep req){
//        return ResponseEntity.ok(usersManagementService.refreshToken(req));
//    }
//
//    @GetMapping("/admin/get-all-users")
//    public ResponseEntity<ReqRep> getAllUsers(){
//        return ResponseEntity.ok(usersManagementService.getAllUsers());
//
//    }
//
//    @GetMapping("/admin/get-users/{usersId}")
//    public ResponseEntity<ReqRep> getUSerByID(@PathVariable Long usersId){
//        return ResponseEntity.ok(usersManagementService.getUsersById(usersId));
//
//    }
//
//    @PutMapping("/admin/update/{usersId}")
//    public ResponseEntity<ReqRep> updateUser(@PathVariable Long usersId, @RequestBody Users reqres){
//        return ResponseEntity.ok(usersManagementService.updateUser(usersId, reqres));
//    }
//
//    @GetMapping("/adminuser/get-profile")
//    public ResponseEntity<ReqRep> getMyProfile(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        ReqRep response = usersManagementService.getMyInfo(email);
//        return  ResponseEntity.status(response.getStatusCode()).body(response);
//    }
//
//    @DeleteMapping("/admin/delete/{usersId}")
//    public ResponseEntity<ReqRep> deleteUSer(@PathVariable Long usersId){
//        return ResponseEntity.ok(usersManagementService.deleteUser(usersId));
//    }
//
//
//}
//
