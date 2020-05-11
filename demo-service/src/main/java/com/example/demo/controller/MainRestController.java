package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class MainRestController {

	// @Autowired
	// private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String hello() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getEmployees() {
		List<Employee> list = employeeService.findAll();
		System.out.println("Response Size: " + list.size());
		return list;
	}

	@RequestMapping(value = "insertEmp", method = RequestMethod.POST) 
	public String AddEmployee(@RequestBody Employee emp) {
		return employeeService.insert(emp);
	}

	@RequestMapping(value = "updateEmp", method = RequestMethod.PUT) 
	public String UpdateEmployee(@RequestBody Employee emp) {
		return employeeService.update(emp);
	}
	
	@RequestMapping(value = "deleteEmp/{empNo}", method = RequestMethod.DELETE) // or use @GetMapping
	public void delete(@PathVariable("empNo") String empNo) {
			employeeService.delete(empNo);
	}

	/*
	 * @RequestMapping(value = "listEmployees", method = RequestMethod.GET) public
	 * List<Employee> listEmployees(){ return employeeService.findAll();
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/employees", method = RequestMethod.GET, produces =
	 * { MediaType.APPLICATION_JSON_VALUE }) public List<Employee> getEmployees() {
	 * List<Employee> list = employeeDAO.getAllEmployees(); return list; }
	 * 
	 * @RequestMapping(value = "/employee/{empNo}", method = RequestMethod.GET,
	 * produces = {MediaType.APPLICATION_JSON_VALUE }) public Employee
	 * getEmployee(@PathVariable("empNo") String empNo) { return
	 * employeeDAO.getEmployee(empNo); }
	 * 
	 */

}
