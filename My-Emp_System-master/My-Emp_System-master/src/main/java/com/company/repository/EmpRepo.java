package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Employee;



@Repository
public interface EmpRepo  extends JpaRepository<Employee, Integer>{

}