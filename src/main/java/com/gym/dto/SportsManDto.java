package com.gym.dto;

import java.util.List;


public class SportsManDto {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String sex;
	
   private String avatar;
   
   private List<SportDto> sports;
  
   private List<PaymentDto> payments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<SportDto> getSports() {
		return sports;
	}

	public void setSports(List<SportDto> sports) {
		this.sports = sports;
	}
	
	public List<PaymentDto> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDto> payments) {
		this.payments = payments;
	}

}
