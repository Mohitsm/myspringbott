package com.employeeMSMS.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeMSMS.entity.Role;
import com.employeeMSMS.exception.ResourceNotFoundException;
import com.employeeMSMS.paylode.RoleDto;
import com.employeeMSMS.repositry.RoleRepo;
import com.employeeMSMS.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RoleDto createRole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		Role role=this.modelMapper.map(roleDto, Role.class);
		Role createRole=this.roleRepo.save(role);
		return this.modelMapper.map(createRole, RoleDto.class);
	}

	@Override
	public RoleDto getRoleById(Integer roleId) {
		// TODO Auto-generated method stub
		Role role=this.roleRepo.findById(roleId).orElseThrow(()-> new ResourceNotFoundException("Role", "Id", roleId));
		return this.modelMapper.map(role, RoleDto.class);
	}

	@Override
	public List<RoleDto> getAllRole() {
		// TODO Auto-generated method stub
		List<Role> role=this.roleRepo.findAll();
		List<RoleDto> getAllRole=role.stream().map((ro) ->this.modelMapper.map(ro, RoleDto.class)).collect(Collectors.toList());
		return getAllRole; 
	}

	@Override
	public long countMaleEmployees() {
		// TODO Auto-generated method stub
		return this.roleRepo.countByGender("Male");
	}

	@Override
	public long countFemaleEmployees() {
		// TODO Auto-generated method stub
		return this.roleRepo.countByGender("Female");
	}
	@Override
	public Long count() {
		// TODO Auto-generated method stub
	
		return roleRepo.count();
	}

	@Override
	public long countTransEmployees() {
		// TODO Auto-generated method stub
		return this.roleRepo.countByGender("trans");
	}

	

	
}
