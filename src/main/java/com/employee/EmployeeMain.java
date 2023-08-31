package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

   @SpringBootApplication
   @EnableMongoRepositories
//   @ComponentScan(basePackages={"com.employee.controller.EmployeeController","com.employee.dao.EmployeeDao","com.employee.service.EmployeeService","com.employee.entity.Employee"})
	public class EmployeeMain {
	    public static void main(String[] args) {
	        SpringApplication.run(EmployeeMain.class, args);
	    }
	}



