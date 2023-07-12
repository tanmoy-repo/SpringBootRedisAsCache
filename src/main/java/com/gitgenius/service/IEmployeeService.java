package com.gitgenius.service;

import java.util.List;

import com.gitgenius.model.Employee;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee e);
	public Employee updateEmployee(Integer empId,Employee e);
	public void deleteEmployee(Integer empId);
	
	public Employee getOneEmployee(Integer empId);
	public List<Employee> getAllEmployee();
	

}
