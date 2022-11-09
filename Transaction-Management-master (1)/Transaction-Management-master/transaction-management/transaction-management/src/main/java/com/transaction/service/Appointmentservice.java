package com.transaction.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.controller.form.AppointmentForm;
import com.transaction.model.Appointment;
import com.transaction.model.Patient;
import com.transaction.repository.AppointmentRepository;
import com.transaction.repository.PatientRepository;

@Service
public class Appointmentservice 
{
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PatientRepository patientrepo;
	
	public String bookAppointment(AppointmentForm appointmentForm)
	{
		
		Patient patient = new ObjectMapper().convertValue(appointmentForm, Patient.class);
		
		Long patientNumber = patientrepo.save(patient).getPatientNumber();
		
		System.out.println("Patient Details saved successfully.");
		
		Appointment appointment = new Appointment(1L, new Date(System.currentTimeMillis()), patientNumber, 101L);
		
		Long appointmentNumber = appointmentRepository.save(appointment).getAppointmentno();

	
		return "Appointment Booked Successfully."+appointmentNumber;
		
	}

}
