package com.practice.employee.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

   

	
	
}
