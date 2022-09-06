package Location;

public class Place {
	
	private String placeName;
	private String zipCode;
	
	public Place(String placeName, String zipCode) {
		super();
		this.placeName  = placeName;
		this.zipCode 	= zipCode;
	}
	
	public Place() {
	}

	
	public synchronized String getPlaceName() {
		return placeName;
	}

	public synchronized void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	public synchronized String getZipCode() {
		return zipCode;
	}

	public synchronized void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

}
