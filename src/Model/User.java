package Model;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;

public abstract class User {
	private String name;
	private String lastName;
	private String email;
	private String password;
	private Gender gender;
	private String phoneNum;
	private Address address;
	private Schedule schedule;
	private Role role;
	
	public User(String name, String lastName, String email, String password, Gender gender, String phoneNum, Address address, Role role) {
		super();
		this.name 		= name;
		this.lastName   = lastName;
		this.email 		= email;
		this.password   = password;
		this.gender 	= gender;
		this.phoneNum   = phoneNum;
		this.address    = address;
		this.role 		= role;
	}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public synchronized Role getRole() {
		return role;
	}

	public synchronized void setRole(Role role) {
		this.role = role;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized Gender getGender() {
		return gender;
	}

	public synchronized void setGender(Gender gender) {
		this.gender = gender;
	}

	public synchronized Address getAddress() {
		return address;
	}

	public synchronized void setAddress(Address address) {
		this.address = address;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getLastName() {
		return lastName;
	}

	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public synchronized String getPhoneNum() {
		return phoneNum;
	}

	public synchronized void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public abstract void logIn();
	//Ovde ubaciti login
	public abstract void logOut();
	public String getData() {
		return this.email+","+this.name+","+this.lastName+","+this.gender+","+ this.password + "," + this.phoneNum+","+this.address.getStreet()+","+ this.address.getHouseNumber()+","+this.address.getPlace().getZipCode()+","+this.role;
	}

}
