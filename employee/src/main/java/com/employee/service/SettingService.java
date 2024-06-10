package com.employee.service;

import java.util.List;


import com.employee.dto.SettingDto;

public interface SettingService {
	
	SettingDto createSetting(SettingDto settingDto);
	SettingDto updateSetting(SettingDto settingDto,Long settingId);
	void deleteSetting(Long settingId);
	SettingDto getSettingId(Long settingId);
	List<SettingDto> getAllSetting();

}
