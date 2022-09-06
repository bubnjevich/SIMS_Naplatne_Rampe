package Model;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;

public class UpperManager extends User implements Manager{

	public UpperManager(String name, String lastName, String email, String password, Gender gender, String phoneNum, Address address, Role role) {
		super(name, lastName, email, password, gender, phoneNum, address, role);
	}
	
	private void createPriceList() {}
	
	private void updatePriceList() {}
	
	private void deletePriceList() {}
	
	@Override
	public void logIn() {
	}

	@Override
	public void logOut() {
	}

	@Override
	public void createFinancialReports() {

	}

	@Override
	public void createMalfunctionReports() {

	}

	@Override
	public void createPassReports() {

	}

	@Override
	public void createShiftSchedules() {

	}

	@Override
	public String getData() {
		return super.getData()+"";
	}
}
