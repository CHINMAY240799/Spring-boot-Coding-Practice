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
import com.practice.employee.service.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final RegisterService registerService;
   	
   	public EmployeeController(RegisterService registerService) {
   		
   		this.registerService = registerService;
   		
   	}
   	
     
   	@PostMapping("/register")
   	public ResponseEntity<String> registerEmployee(@Valid @RequestBody EmployeeDto request) {
   	   registerService.registerEmployee(request);
   	return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added Successfully");
   	}
   	
   	@GetMapping("/{id}")
   	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id ){
   		
   		EmployeeDto employeeDto =  registerService.getEmployee(id);
   		
   		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
   		
   	}
   	
   	@PutMapping("/update/{id}")
   	public ResponseEntity<String> updateEmployee(@PathVariable Long id ,@Valid @RequestBody EmployeeDto request){
   		
   		registerService.updateEmployee(id, request);
   		
   		return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
   		
   		
   	}
   	
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity<String> deleteEmployee(@PathVariable  Long id){
   		
   		registerService.deleteEmployee(id);
   		
   		
   		return ResponseEntity.noContent().build();
   	}
   	
}
