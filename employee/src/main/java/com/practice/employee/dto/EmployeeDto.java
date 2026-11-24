package com.practice.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
	
	@NotBlank(message = "Name is required")
	 private String name;
	@NotBlank(message = "Department is required")
     private String department;
	@NotNull(message = "Manager status (true/false) is required")
     private Boolean manager;
	
     public String getName() {
		return name;
	}

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getDepartment() {
		 return department;
	 }

	 public void setDepartment(String department) {
		 this.department = department;
	 }

	 public boolean isManager() {
		 return manager;
	 }

	 public void setManager(boolean manager) {
		 this.manager = manager;
	 }

	 public EmployeeDto(String name, String department, boolean manager) {
		super();
		this.name = name;
		this.department = department;
		this.manager = manager;
	}

	public EmployeeDto() {
		
	}
     
     
}
