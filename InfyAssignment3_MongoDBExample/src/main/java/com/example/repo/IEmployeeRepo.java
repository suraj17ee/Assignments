package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String>{

}
