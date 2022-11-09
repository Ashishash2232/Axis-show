package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Mono<Emp> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}
	
	@Override
	public Flux<Emp> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Mono<Emp> save(Emp emp) {
		return employeeRepository.save(emp);
	}
	
	@Override
	public Mono<Void> deleteById(Long id) {
		return employeeRepository.deleteById(id);
	}
	
}
