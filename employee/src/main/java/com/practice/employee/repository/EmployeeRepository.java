package com.practice.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

   List<Employee> findBydepartment(String Department);

	
	
}
