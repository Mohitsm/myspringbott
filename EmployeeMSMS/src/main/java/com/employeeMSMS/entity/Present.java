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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "presents")
public class Present {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer presentId;
 private  String od;
 private String leava;
 private String absent;
}
