package com.transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long PatientNumber;
	private String Name;
	private String Gender;
	private int Age;
	private Long Mobile;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Long patientNumber, String name, String gender, int age, Long mobile) {
		super();
		this.PatientNumber = patientNumber;
		Name = name;
		Gender = gender;
		Age = age;
		Mobile = mobile;
	}
	public Long getPatientNumber() {
		return PatientNumber;
	}
	public void setPatientNumber(Long patientNumber) {
		PatientNumber = patientNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Long getMobile() {
		return Mobile;
	}
	public void setMobile(Long mobile) {
		Mobile = mobile;
	}
	
}
