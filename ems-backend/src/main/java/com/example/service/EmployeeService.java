package com.example.service;

import java.util.List;

import com.example.model.Employee;


public interface EmployeeService {
	
//	Add Employee
	Employee saveEmployee(Employee employee);
	
//	List All Employees
	List<Employee> fetchEmployeeList();
	
//	Get Employee by Id
	Employee fetchEmployee(Long employeeId);
	
//	Update Employee 
	Employee updateEmployee(Employee employee, Long employeeId);
	
//	Delete Employee by Id
	void deleteEmployeeById(Long employeeId);
}
