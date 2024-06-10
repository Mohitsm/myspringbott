package com.employee.repositiry
;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Setting;




public interface SettingRepo extends JpaRepository<Setting, Long> {

}
