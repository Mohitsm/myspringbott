package com.employeeMSMS.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Previous_Work")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PreviousWork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer previousWorkId;
	private String company;
	private String designationName;
	private String fromData;
	private String toData;
	private String duration;

}
