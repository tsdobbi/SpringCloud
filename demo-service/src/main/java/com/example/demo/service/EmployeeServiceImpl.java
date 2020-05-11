package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public String insert(Employee emp) {
		Employee empReturn = employeeRepository.insert(emp);
		if(empReturn != null) {
			return "SUCCESSFUL INSERT";
		} else {
			return "FAILED TO INSERT";
		}

	}
	
	@Override
	public String update(Employee emp) {
		Employee empReturn = employeeRepository.save(emp);
		if(empReturn != null) {
			return "SUCCESSFUL UPDATE";
		} else {
			return "FAILED TO INSERT";
		}

	}

	
	@Override
	public void delete(String empNo) {
		employeeRepository.deleteById(empNo);

	}
	
	/*
	@Override
	public Optional<Employee> findById(String empNo) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empNo);
	}

	@Override
	public void deleteById(String empNo) {
		employeeRepository.deleteById(empNo);

	}
	*/


}
