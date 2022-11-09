package com.transaction.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Appointment 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Appointmentno;
	private Date date;


	private Long PatientNumber;
	private Long doctorno;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Long appointmentno, Date date, Long patientNumber, Long doctorno) {
		super();
		Appointmentno = appointmentno;
		this.date = date;
		PatientNumber = patientNumber;
		this.doctorno = doctorno;
	}
	public Long getAppointmentno() {
		return Appointmentno;
	}
	public void setAppointmentno(Long appointmentno) {
		Appointmentno = appointmentno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getPatientNumber() {
		return PatientNumber;
	}
	public void setPatientNumber(Long patientNumber) {
		PatientNumber = patientNumber;
	}
	public Long getDoctorno() {
		return doctorno;
	}
	public void setDoctorno(Long doctorno) {
		this.doctorno = doctorno;
	}
		
}
