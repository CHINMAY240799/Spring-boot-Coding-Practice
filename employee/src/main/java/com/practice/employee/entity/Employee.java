package com.practice.employee.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
  
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long employeeId;
     private String name;
     private String department;
     private Integer salary;
     private boolean manager;
     
	 public Employee() {
		
	}

	 public Employee( String name,String department, boolean manager) {
		super();
		this.name =name;
		this.department = department;
		this.manager = manager;
	 }
    
     public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
     
     
}
