package com.gitgenius.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gitgenius.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
