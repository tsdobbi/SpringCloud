package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	@Override
	List<Employee> findAll();	
	<S extends Employee> S insert(S Employee); 
	<S extends Employee> S save(S Employee); 
	//void deleteById (String empNo);
	

}
