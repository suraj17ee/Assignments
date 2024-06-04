package com.example.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.document.Employee;
import com.example.repo.IEmployeeRepo;
import com.example.service.IEmployeeService;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repository;

	@Override
	public String saveEmployeeData(Employee emp) {
		return repository.save(emp).getEmployeeId() + " employee details saved successfully !";
	}

	@Override
	public Iterable<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee findEmployeeById(String eid) {
		return repository.findById(eid).orElseThrow(() -> new IllegalArgumentException("Invalid EmployeeId!!"));
	}

	@Override
	public String modifyEmployeeData(String eid, String name) {
		// find employee by id
		Optional<Employee> opt = repository.findById(eid);
		if (opt.isPresent()) {
			Employee emp = opt.get();
			emp.setEmployeeName(name);
			String dbEmpId = repository.save(emp).getEmployeeId();
			// save calls persist for save document and merge to update document
			return dbEmpId + " name updated !!";
		}
		return eid + "employee details does not exist !";
	}

	@Override
	public String removeEmployee(String eid) {
		Optional<Employee> opt = repository.findById(eid);
		if (opt.isPresent()) {
			Employee emp = opt.get();
			repository.delete(emp);
			return eid + " document deleted !!";
		}
		return eid + " document not present !!";
	}

}
