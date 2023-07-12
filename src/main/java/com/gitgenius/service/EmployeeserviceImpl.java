package com.gitgenius.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gitgenius.ResourceNotFoundException;
import com.gitgenius.model.Employee;
import com.gitgenius.repo.EmployeeRepo;


@Service
public class EmployeeserviceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee saveEmployee(Employee e) {
		
		
		return repo.save(e);
	}

	@Override
	@CachePut(value = "employees" , key = "#empId")
	public Employee updateEmployee(Integer empId, Employee e) {
		Employee emp = repo.findById(empId)
				       .orElseThrow(()->new ResourceNotFoundException("Employee Not Exist"));
		
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		return repo.save(emp);
	}

	@Override
	@CacheEvict(value = "employees" , key = "#empId")
	public void deleteEmployee(Integer empId) {
		Employee emp = repo.findById(empId)
			       .orElseThrow(()->new ResourceNotFoundException("Employee Not Exist"));
       repo.deleteById(empId);
	}

	@Override
	@Cacheable(value = "employees" , key = "#empId")
	public Employee getOneEmployee(Integer empId) {
		Employee emp = repo.findById(empId)
			       .orElseThrow(()->new ResourceNotFoundException("Employee Not Exist"));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}
