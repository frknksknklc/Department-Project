package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentServiceImpl;
import org.jboss.logging.*;

import ch.qos.logback.classic.Logger;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final org.jboss.logging.Logger logger = LoggerFactory.logger(DepartmentController.class); 
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody  Department department) {
		logger.info("inside saveDepartment of Controller"); 
			return departmentService.saveDepartment(department);
			
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		logger.info("inside fetchDepartmentList of Controller"); 
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long deparmentId) throws DepartmentNotFoundException {
		logger.info("inside fetchDepartmentById of Controller"); 
		return departmentService.fetchDepartmentById(deparmentId);
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("inside deleteDepartmentById of Controller"); 
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, 
																			@RequestBody Department department) {
		logger.info("inside updateDepartment of Controller"); 
		return departmentService.updateDepartment(departmentId,department);
			
	}
	
	 @GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) { 
		 logger.info("inside fetchDepartmentByName of Controller"); 
		return departmentService.fetchDepartmentByName(departmentName);
	}
	 
	 
	
}
