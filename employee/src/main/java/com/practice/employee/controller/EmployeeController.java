package com.practice.employee.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee.dto.EmployeeDto;
import com.practice.employee.dto.EmployeeResponseDto;
import com.practice.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
   	
   	public EmployeeController(EmployeeService registerService) {
   		
   		this.employeeService = registerService;
   		
   	}
   	
     
   	@PostMapping
   	public ResponseEntity<String> registerEmployee(@Valid @RequestBody EmployeeDto request) {
   	   employeeService.createEmployee(request);
   	return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added Successfully");
   	}
   	
   	@GetMapping("/{id}")
   	public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable Long id ){
   		
   		EmployeeResponseDto employeeResponseDto =  employeeService.getEmployeeById(id);
   		
   		return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
   		
   	}
   	
   	@PutMapping("/{id}")
   	public ResponseEntity<String> updateEmployee(@PathVariable Long id ,@Valid @RequestBody EmployeeDto request){
   		
   		employeeService.updateEmployee(id, request);
   		
   		return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
   		
   		
   	}
   	
   	@DeleteMapping("/{id}")
   	public ResponseEntity<String> deleteEmployee(@PathVariable  Long id){
   		
   		employeeService.deleteEmployeeById(id);
   		
   		
   		return ResponseEntity.noContent().build();
   	}
   	
   	@GetMapping("/department")
   	public ResponseEntity<List<EmployeeResponseDto>> getEmployeesByDepartment(@RequestParam String department){
   		
   		List<EmployeeResponseDto> employeeList =  employeeService.getEmployeesByDepartment(department);
   		return ResponseEntity.ok(employeeList);
   	}
   	
   	@GetMapping
   	public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(@RequestParam(defaultValue = "0") int page,
   			@RequestParam(defaultValue = "10") int size,
   			@RequestParam(defaultValue = "employeeId") String employeeId,
   			@RequestParam(defaultValue = "desc") String direction
   	
   			) {
   		
   		
   		Page<EmployeeResponseDto> employeeResponse = employeeService.getAllEmployees(page, size,employeeId,direction);
   		
   		return ResponseEntity.ok(employeeResponse);
   	}
   	
   	
   	
   	
   	
}
