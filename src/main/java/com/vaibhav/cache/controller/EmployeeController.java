/**
 * 
 */
package com.vaibhav.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.cache.pojo.Employee;
import com.vaibhav.cache.services.EmployeeService;

/**
 * @author Vaibhav.Singh
 *
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping(value="/emp/{id}")
	public Employee getEmployee(@PathVariable("id") String id) throws InterruptedException {
		System.out.println("EmployeeController.getEmployee()");
		Employee em = new Employee();
		em = employeeService.getEmployee(id);
		
		return em;
	}
	
	@DeleteMapping(value="/emp/{id}")
	public Boolean deleteEmployee(@PathVariable("id") String id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping(value="/emp/{id}/{email}")
	public Employee updateEmployee(@PathVariable("id") String id, @PathVariable("email") String name) {
		return employeeService.updateEmployee(id, name);
	}
	
	
}
