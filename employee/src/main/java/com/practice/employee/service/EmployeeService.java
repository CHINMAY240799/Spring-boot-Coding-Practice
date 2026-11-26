package com.practice.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.employee.dto.EmployeeDto;
import com.practice.employee.dto.EmployeeResponseDto;
import com.practice.employee.entity.Employee;
import com.practice.employee.exception.EmployeeNotFoundException;
import com.practice.employee.repository.EmployeeRepository;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository registerRepository) {
		this.employeeRepository = registerRepository;
	}
	
    
	@Transactional
	public void createEmployee(EmployeeDto employeeDto) {
		 
		String name = employeeDto.getName();
		String department = employeeDto.getDepartment();
		boolean manager = employeeDto.isManager();
		 
		Employee employee = new Employee(name,department,manager);
		
		if(manager)
			employee.setSalary(1000);
		else
			employee.setSalary(500);
		
		employeeRepository.save(employee);
	
		
	}
	
	public EmployeeResponseDto getEmployeeById(Long employeeId) {
		
	  Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found " + employeeId));
	  
      EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
      employeeResponseDto.setEmployeeId(employee.getEmployeeId());
      employeeResponseDto.setName(employee.getName());
      employeeResponseDto.setDepartment(employee.getDepartment());
      employeeResponseDto.setManager(employee.isManager());
      employeeResponseDto.setSalary(employee.getSalary());
      
   
	  return employeeResponseDto;
			
	}
	@Transactional
	public void updateEmployee(Long id, EmployeeDto updateDto) {
		
		  Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found " + id));
		
		  employee.setName(updateDto.getName());
		  employee.setDepartment(updateDto.getDepartment());
		  employee.setManager(updateDto.isManager());
		  employeeRepository.save(employee);
		
	}
	
	@Transactional
	public void deleteEmployeeById(Long employeeId) {
	   
	    Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
	                    new EmployeeNotFoundException(
	                            "Employee not found with ID: " +  employeeId));
	    
	    
		employeeRepository.deleteById(employeeId);
		
	}
	
	public List<EmployeeResponseDto> getEmployeesByDepartment(String department){
		
	  List<Employee> employees = employeeRepository.findBydepartment(department);
	  
	  List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
	  
	      for(Employee employee : employees) {
	    	    EmployeeResponseDto response =
	                    new EmployeeResponseDto();

	            response.setEmployeeId(employee.getEmployeeId());
	            response.setName(employee.getName());
	            response.setDepartment(employee.getDepartment());
	            response.setSalary(employee.getSalary());
	            response.setManager(employee.isManager());

	    	 
	            employeeResponseDtos.add(response);
	      }
	  
	  
	   return employeeResponseDtos;
		
	}
	
	
}
