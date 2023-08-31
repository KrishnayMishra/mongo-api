package com.employee.dao;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao extends MongoRepository<Employee, String>{
	  
	
	    

	    // Custom query to find employees by their name
	    List<Employee> findByEmployeeName(String employeeName);

	    // Custom query to find employees by their email
	    Optional<Employee> findByEmail(String email);

	    // Custom query to find employees by their phone number
	    List<Employee> findByPhoneNumber(String phoneNumber);

	    // Custom query to find employees by the ID of the reporting manager
	    List<Employee> findByReportsTo(String reportsTo);

		
	    
	   

		//Page<Employee> findAll(Pageable pageable);

}



