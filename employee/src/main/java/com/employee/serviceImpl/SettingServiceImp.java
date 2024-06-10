package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Setting;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.SettingDto;
import com.employee.repositiry.SettingRepo;
import com.employee.service.SettingService;
@Service
public class SettingServiceImp implements SettingService{
	
	@Autowired
	private SettingRepo settingRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SettingDto createSetting(SettingDto settingDto) {
		// TODO Auto-generated method stub
		Setting setting=this.modelMapper.map(settingDto, Setting.class);
		Setting createSetting=this.settingRepo.save(setting);
		return this.modelMapper.map(createSetting, SettingDto.class);
	}

	@Override
	public SettingDto updateSetting(SettingDto settingDto, Long settingId) {
		// TODO Auto-generated method stub
		Setting setting=this.settingRepo.findById(settingId).orElseThrow(()-> new ResourceNotFoundException("Setting","Id", settingId));
		setting.setName(settingDto.getName());
		setting.setUsername(settingDto.getUsername());
		setting.setEmail(settingDto.getEmail());
		Setting updateSetting=this.settingRepo.save(setting);
		return this.modelMapper.map(updateSetting, SettingDto.class);
	}

	@Override
	public void deleteSetting(Long settingId) {
		// TODO Auto-generated method stub
		Setting setting=this.settingRepo.findById(settingId).orElseThrow(()-> new ResourceNotFoundException("Setting","Id", settingId));

		this.settingRepo.delete(setting);
		
	}

	@Override
	public SettingDto getSettingId(Long settingId) {
		// TODO Auto-generated method stub
		Setting setting=this.settingRepo.findById(settingId).orElseThrow(()-> new ResourceNotFoundException("Setting","Id", settingId));

		return this.modelMapper.map(setting, SettingDto.class);
	}

	@Override
	public List<SettingDto> getAllSetting() {
		// TODO Auto-generated method stub
		List<Setting> settings=this.settingRepo.findAll();
		List<SettingDto> settingDtos=settings.stream().map((se)->this.modelMapper.map(se, SettingDto.class)).collect(Collectors.toList());
		return settingDtos;
	}

}
