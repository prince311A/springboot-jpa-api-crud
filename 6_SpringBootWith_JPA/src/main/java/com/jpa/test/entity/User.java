package com.jpa.test.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int User_Id;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private String phone;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_Id, String name, String city, String phone) {
		super();
		User_Id = user_Id;
		this.name = name;
		this.city = city;
		this.phone = phone;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [User_Id=" + User_Id + ", name=" + name + ", city=" + city + ", phone=" + phone + "]";
	}
	
}
