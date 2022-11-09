package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("employee")
public class EmployeeReactiveController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeReactiveController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/{id}")
	public Mono<Emp> getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping
	public Flux<Emp> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@PutMapping
	public Mono<Emp> saveNew(@RequestBody Emp emp) {
		return employeeService.save(emp);
	}
	
	@PostMapping
	public Mono<Emp> update(@RequestBody Emp emp) {
		return employeeService.save(emp);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable Long id) {
		return employeeService.deleteById(id);
	}
//	@DeleteMapping
//	public Mono<Emp>deleteUser(@PathVariable Long id){
//		return employeeService.findById(id)
//				.flatMap(exist)
//	}

}
