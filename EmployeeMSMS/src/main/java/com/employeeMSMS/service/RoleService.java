package com.employeeMSMS.service;

import java.util.List;

import com.employeeMSMS.paylode.RoleDto;

public interface RoleService {
	
	RoleDto createRole(RoleDto roleDto);
	RoleDto getRoleById(Integer roleId);
	List<RoleDto> getAllRole();
	public long countMaleEmployees();
	public long countFemaleEmployees();
	public long countTransEmployees();
	public Long count();
	 

}
