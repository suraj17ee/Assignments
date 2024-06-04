package com.example.service;

import com.example.document.Employee;

public interface IEmployeeService {

	public String saveEmployeeData(Employee empployee);

	public Iterable<Employee> findAllEmployees();

	public Employee findEmployeeById(String employeeId);

	public String modifyEmployeeData(String employeeId, String name);

	public String removeEmployee(String employeeId);
}
