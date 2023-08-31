package com.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import java.util.List;
import java.util.Optional;

    @RestController
	@RequestMapping("/employees")
	public class EmployeeController {

	    private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }
	    
//	    @GetMapping("/")
//	    public String getOk() {
//	        return ""
//	    }
	    
	    @GetMapping (path="/")
	    public ResponseEntity<String> check() {
	    	
	    	return new ResponseEntity<>("Working", HttpStatus.OK);
	    	
	    }

	    @PostMapping("/addemployees")
	    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
	        String employeeId = employeeService.addEmployee(employee);
	      //  System.out.println(employeeId);
	        
	        return new ResponseEntity<>(employeeId, HttpStatus.CREATED);
	    }

	    @GetMapping("/getemployees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    @GetMapping("/getemployee{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
	        Optional<Employee> employee = employeeService.getEmployeeById(id);
	        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("updateemployee/{id}")
	    public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
	        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
	        if (existingEmployee.isPresent()) {
	            employee.setId(id);
	            employeeService.updateEmployee(employee);
	            return new ResponseEntity<>("Updated",HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("NotFound",HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("deleteemployee/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
	        Optional<Employee> employee = employeeService.getEmployeeById(id);
	        if (employee.isPresent()) {
	            employeeService.deleteEmployee(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	   
	    

    }



