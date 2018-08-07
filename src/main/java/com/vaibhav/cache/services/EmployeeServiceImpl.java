package com.vaibhav.cache.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vaibhav.cache.dao.EmployeeDao;
import com.vaibhav.cache.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Cacheable(value="myCache",key="#id",unless="#result==null")
	@Override
	public Employee getEmployee(String id) throws InterruptedException {
		Thread.sleep(10000);
		
		return employeeDao.getOne(Long.parseLong(id));
	}

	@CacheEvict(value="myCache",key="#id")
	@Override
	public Boolean deleteEmployee(String id) {
		
		employeeDao.deleteById(Long.parseLong(id));
		return true;
	}

	@CachePut(value="myCache",key="#id")
	@Override
	public Employee updateEmployee(String id, String name) {
		
		Employee em = employeeDao.findById(Long.parseLong(id)).orElse(new Employee());
		em.setName(name);
		em = employeeDao.save(em);
		return em;
	}

}
