package com.springbootdemo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo.model.Employee;

public interface EmployeeService extends JpaRepository<Employee,Long> {

}
