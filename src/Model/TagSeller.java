package Model;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;

public class TagSeller extends User {

	public TagSeller(String name, String lastName, String email, String password, Gender gender, String phoneNum, Address address, Role role) {
		super(name, lastName, email, password, gender, phoneNum, address, role);
	}
	
	private void createNewTag() {
		
	}

	private void addCredit() {
		
	}
	
	private void checkStateTag() {
		
	}
	
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
