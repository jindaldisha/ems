package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
//	Add Operation
	@PostMapping("/employees")
	public Employee saveEmployee(
			@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
//	Read Operation (All Employees)
	@GetMapping("/employees")
	public List<Employee> fetchEmployeeList(){
		return employeeService.fetchEmployeeList();
	}

//	Read Operation (Single Employee)
	@GetMapping("/employee/{id}")
	public Employee fetchEmployee(@PathVariable("id") Long employeeId) {
		return employeeService.fetchEmployee(employeeId);
	}
	
//	Update Operation
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") Long employeeId) {
		return employeeService.updateEmployee(employee, employeeId);	
	}
	
//	Delete Operation
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return "Deleted Successfully";
	}
	
	
}
