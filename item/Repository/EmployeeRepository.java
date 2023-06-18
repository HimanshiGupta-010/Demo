package com.assign.item.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.item.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	   
	}

