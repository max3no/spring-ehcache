package com.vaibhav.cache.services;

import com.vaibhav.cache.pojo.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(String id) throws InterruptedException;
	
	public Boolean deleteEmployee(String id);
	
	public Employee updateEmployee(String id, String name);

}
