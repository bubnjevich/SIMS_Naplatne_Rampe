package Model;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;

public class BilingOfficer extends User {

	public BilingOfficer(String name, String lastName, String email, String password, Gender gender, String phoneNum, Address address, Role role) {
		super(name, lastName, email, password, gender, phoneNum, address, role);
		// TODO Auto-generated constructor stub
	}
	
	private void charge() {
	}

	@Override
	public void logIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getData() {
		return super.getData()+"";
	}

}
