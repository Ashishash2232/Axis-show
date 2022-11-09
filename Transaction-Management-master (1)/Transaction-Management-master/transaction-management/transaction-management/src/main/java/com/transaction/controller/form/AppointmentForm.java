package com.transaction.controller.form;

public class AppointmentForm {

	private String Name;
	private String Gender;
	private int Age;
	private String Mobile;
	public AppointmentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentForm(String name, String gender, int age, String mobile) {
		super();
		Name = name;
		Gender = gender;
		Age = age;
		Mobile = mobile;
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
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	
	
}
