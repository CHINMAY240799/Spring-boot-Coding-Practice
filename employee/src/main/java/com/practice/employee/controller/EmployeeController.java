package com.practice.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee.dto.EmployeeDto;
import com.practice.employee.dto.EmployeeResponseDto;
import com.practice.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService registerService;
   	
   	public EmployeeController(EmployeeService registerService) {
   		
   		this.registerService = registerService;
   		
   	}
   	
     
   	@PostMapping
   	public ResponseEntity<String> registerEmployee(@Valid @RequestBody EmployeeDto request) {
   	   registerService.createEmployee(request);
   	return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added Successfully");
   	}
   	
   	@GetMapping("/{id}")
   	public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable Long id ){
   		
   		EmployeeResponseDto employeeResponseDto =  registerService.getEmployeeById(id);
   		
   		return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
   		
   	}
   	
   	@PutMapping("/{id}")
   	public ResponseEntity<String> updateEmployee(@PathVariable Long id ,@Valid @RequestBody EmployeeDto request){
   		
   		registerService.updateEmployee(id, request);
   		
   		return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
   		
   		
   	}
   	
   	@DeleteMapping("/{id}")
   	public ResponseEntity<String> deleteEmployee(@PathVariable  Long id){
   		
   		registerService.deleteEmployeeById(id);
   		
   		
   		return ResponseEntity.noContent().build();
   	}
   	
}
