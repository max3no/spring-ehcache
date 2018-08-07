package com.vaibhav.cache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.cache.pojo.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	

}
