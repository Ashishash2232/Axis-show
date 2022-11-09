package com.transaction.controller;

import com.transaction.model.Patient;
import com.transaction.repository.PatientRepository;
import com.transaction.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

import com.transaction.controller.form.AppointmentForm;
//import com.transaction.model.Patient;
import com.transaction.service.Appointmentservice;

import java.util.List;

@RestController
@RequestMapping("/form")
public class BookAppointmentController
{
	@Autowired
	private Appointmentservice appointmentService;
	@Autowired
	private PatientRepository patRepo;
	

	@PostMapping("/fill")
	public String bookAppointment(@RequestBody AppointmentForm appointmentForm) 
	{
		return appointmentService.bookAppointment(appointmentForm);
		
	}


	@GetMapping("/get")
	public ResponseEntity<List<Patient>> getAll(){
		return ResponseEntity.ok(patRepo.findAll());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Patient> findById(@PathVariable Long id){

		return ResponseEntity.ok(patRepo.findById(id).orElse(null));

	}

	@PutMapping("/update")
	public ResponseEntity<Patient> update(@RequestBody Patient pat){

		return ResponseEntity.ok(patRepo.save(pat));
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Patient> delete(@PathVariable Long id){

		patRepo.findById(id).ifPresent(patRepo::delete);
		return ResponseEntity.ok().build();
	}

}
