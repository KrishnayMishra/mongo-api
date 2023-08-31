package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


   @Service
	public class EmployeeService {

	    private final EmployeeDao employeedao;

	    @Autowired
	    public EmployeeService(EmployeeDao employeedao) {
	        this.employeedao = employeedao;
	    }

	    public String addEmployee(Employee employee) {
	        // Generate a unique UUID for the employee
	        String uuid = UUID.randomUUID().toString();
	        employee.setId(uuid);

	        Employee savedEmployee = employeedao.save(employee);
	        return savedEmployee.getId();
	    }

	    public List<Employee> getAllEmployees() {
	        return employeedao.findAll();
	    }

	    public Optional<Employee> getEmployeeById(String id) {
	        return employeedao.findById(id);
	    }

	    public void updateEmployee(Employee employee) {
	        employeedao.save(employee);
	    }

	    public void deleteEmployee(String id) {
	        employeedao.deleteById(id);
	    }
	    
	   
	    
	    
	   
//	    public Page<Employee> getAllEmployees(Pageable pageable) {
//	        return employeedao.findAll(pageable);
//	    }
   }



