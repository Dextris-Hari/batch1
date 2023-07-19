package com.xworkz.employeesentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees_info")
public class EmployeesEntity {
	
	
	public EmployeesEntity(String name) {
		super();
		this.name = name;
	}
	@Id
	private Integer id;
	private String name;
	

}
