package com.gitgenius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitgenius.model.Employee;
import com.gitgenius.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(service.getAllEmployee());
	}
	@GetMapping("/one/{empId}")
	public Employee getOneEmployee(@PathVariable Integer empId){
		return service.getOneEmployee(empId);
		
	}
	
	@PutMapping("/modify/{empId}")
	public Employee updateEmpoyee(
			@PathVariable Integer empId,
			@RequestBody Employee employee)
	{
		Employee emp = service.updateEmployee(empId, employee);
		return emp;
	}
	
	@DeleteMapping("/remove/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		service.deleteEmployee(empId);
		return "Deleted employee"+empId;
	}

}
