package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;



public interface EmployeeService {

		List<Employee> findAll();
		String insert(Employee emp);
		String update(Employee emp);
		void delete(String empNo);
		
		
	}
