package com.learning.spring.UserModel;

import org.springframework.stereotype.Component;

@Component
public class UserModel {

	private int Id;
	private String Name;
	private String Email;
	private String Addr;
	private String Phone;
	public int getId() {
		return Id;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserModel [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Addr=" + Addr + ", Phone=" + Phone
				+ "]";
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
}
