package com.practice.employee.dto;

public class EmployeeResponseDto {

	 private Long employeeId;
     private String name;
     private String department;
     private Integer salary;
     private boolean manager;
	
	 public EmployeeResponseDto() {
		super();
	}
	 public EmployeeResponseDto(Long employeeId, String name, String department, Integer salary, boolean manager) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.manager = manager;
	}
	 public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}

     
     
}
