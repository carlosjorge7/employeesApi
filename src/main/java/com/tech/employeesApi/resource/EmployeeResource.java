package com.tech.employeesApi.resource;

import java.util.List;
import java.util.Optional;

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

import com.tech.employeesApi.model.Employee;
import com.tech.employeesApi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
	private EmployeeService employeeService;
	
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Optional<Employee> employee = employeeService.findEmployeeById(id);
		return new ResponseEntity(employee, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Delete employee", HttpStatus.OK);
	} 
	
}