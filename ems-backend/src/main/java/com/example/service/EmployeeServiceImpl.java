package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	Save Operation
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
//	Read Operation (All Employees)
	@Override
	public List<Employee> fetchEmployeeList(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
//	Read Operation (Single Employee)
	@Override
	public Employee fetchEmployee(Long employeeId){
		return employeeRepository.findById(employeeId).get();
	}
	
//	Update Operation
	@Override
	public Employee updateEmployee(Employee employee, Long employeeId) {
		Employee empDB = employeeRepository.findById(employeeId).get();
		
		if(Objects.nonNull(employee.getEmployeeUserName()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeUserName())) {
			empDB.setEmployeeUserName(employee.getEmployeeUserName());
		}
		if(Objects.nonNull(employee.getEmployeeFirstName()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeFirstName())) {
			empDB.setEmployeeFirstName(employee.getEmployeeFirstName());
		}
		if(Objects.nonNull(employee.getEmployeeLastName()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeLastName())) {
			empDB.setEmployeeLastName(employee.getEmployeeLastName());
		}
		if(Objects.nonNull(employee.getEmployeeAddress()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeAddress())) {
			empDB.setEmployeeAddress(employee.getEmployeeAddress());
		}
		if(Objects.nonNull(employee.getEmployeeDepartment()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeDepartment())) {
			empDB.setEmployeeDepartment(employee.getEmployeeDepartment());
		}
		if(Objects.nonNull(employee.getEmployeeRole()) 
				&& !"".equalsIgnoreCase(employee.getEmployeeRole())) {
			empDB.setEmployeeRole(employee.getEmployeeRole());
		}
		
		return employeeRepository.save(empDB);
	}
	
//	Delete Operation
	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
