package Model;

import Location.Address;

public class TagOwner {
	private String name;
	private String lastName;
	private String email;
	private String phoneNum;
	private Address address;

	public TagOwner(String name, String lastName, String email, String phoneNum, Address address) {
		this.name 	  = name;
		this.lastName = lastName;
		this.email 	  = email;
		this.phoneNum = phoneNum;
		this.address  = address;
	}

	public String getData() {
		return this.name+","+this.lastName+","+this.email+","+this.phoneNum+","+this.address.getStreet();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
