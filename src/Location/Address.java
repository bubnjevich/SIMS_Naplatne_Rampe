package Location;

public class Address {

	
	private String street;
	private String houseNumber;
	private Place place;

	public Address() {}
	
	public Address(String street, String houseNumber, Place place) {
		super();
		this.street 	 = street;
		this.houseNumber = houseNumber;
		this.place 		 = place;
	}

	public Address(String street) {
		super();
		this.street = street;

	}

	public synchronized String getStreet() {
		return street;
	}

	public synchronized void setStreet(String street) {
		this.street = street;
	}

	public synchronized String getHouseNumber() {
		return houseNumber;
	}

	public synchronized void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public synchronized Place getPlace() {
		return place;
	}

	public synchronized void setPlace(Place place) {
		this.place = place;
	}

}
