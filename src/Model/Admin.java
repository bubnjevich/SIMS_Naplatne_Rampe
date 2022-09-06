package Model;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;

public class Admin extends User {
	
	
	public Admin(String name, String lastName, String email, String password, Gender gender, String phoneNum, Address address, Role role) {
		super(name, lastName, email, password, gender, phoneNum, address, role);
	}



	private void createUser() {}
	
	private void updateUser() {}


	@Override
	public void logIn() {
	}

	@Override
	public void logOut() {
		
	}

	@Override
	public String getData() {
		return super.getData()+"";
	}

	
}
