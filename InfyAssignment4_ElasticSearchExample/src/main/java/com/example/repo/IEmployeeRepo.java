package com.example.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.document.Employee;

public interface IEmployeeRepo extends ElasticsearchRepository<Employee, String>{

}
