package com.example.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "test_collection")
public class Employee {

	@Id
	private String employeeId;
	private String employeeName;
	private String employeeStatus;
	private String employeeDesignation;

}
