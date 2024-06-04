package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.document.Employee;
import com.example.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployeeDetails(@RequestBody Employee employee) {
		String message = employeeService.saveEmployeeData(employee);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{eid}")
	public ResponseEntity<String> removeEmployeeDetails(@PathVariable String eid) {
		String message = employeeService.removeEmployee(eid);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/get/{eid}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable String eid) {
		Employee employee = employeeService.findEmployeeById(eid);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Employee>> getAllEmployeeDetails() {
		Iterable<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PutMapping("/update/{eid}")
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable String eid, String name) {
		String message = employeeService.modifyEmployeeData(eid, name);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
