package com.practice.employee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.employee.dto.EmployeeDto;
import com.practice.employee.entity.Employee;
import com.practice.employee.repository.EmplopyeeRepository;

@Service
public class RegisterService {

	public EmplopyeeRepository empoloyeeRepository;
	
	public RegisterService(EmplopyeeRepository registerRepository) {
		this.empoloyeeRepository = registerRepository;
	}
	
    
	@Transactional
	public void registerEmployee(EmployeeDto employeeDto) {
		 
		String name = employeeDto.getName();
		String department = employeeDto.getDepartment();
		boolean manager = employeeDto.isManager();
		 
		Employee employee = new Employee(name,department,manager);
		
		if(manager)
			employee.setSalary(1000);
		else
			employee.setSalary(500);
		
		empoloyeeRepository.save(employee);
	
		
	}
	
	public EmployeeDto getEmployee(Long id) {
		
	  Employee employee = empoloyeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
	  
	  EmployeeDto employeeDto = new EmployeeDto();
	  employeeDto.setName(employee.getName());
	  employeeDto.setDepartment(employee.getDepartment());
	  employeeDto.setManager(employee.isManager());
	  
	  return employeeDto;
			
	}
	
	public void updateEmployee(Long id, EmployeeDto updateDto) {
		
		  Employee employee = empoloyeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
		
		  employee.setName(updateDto.getName());
		  employee.setDepartment(updateDto.getDepartment());
		  employee.setManager(updateDto.isManager());
		  empoloyeeRepository.save(employee);
		
	}
	
	public void deleteEmployee(Long id) {
	    
	    Employee employee = empoloyeeRepository.findById(id).orElseThrow(() ->
	                    new RuntimeException(
	                            "Employee not found with ID: " + id));
	    
	    
		empoloyeeRepository.deleteById(id);
		
	}
	
}
