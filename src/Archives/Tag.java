package Archives;
import Enumerations.Currency;
import Model.TagOwner;
import Model.Vehicle;
import Property.SetProperty;

import java.util.Set;


public class Tag {

	private String id;
	private float balance;
	private Currency currency;
	private TagOwner tagOwner;
	private Vehicle vehicle;
	private final SetProperty<ScannedTag> scannedTags = new SetProperty<>();

	public Tag(String id, float balance, Currency currency,TagOwner tagOwner, Vehicle vehicle) {
		super();
		this.id 	  = id;
		this.balance  = balance;
		this.currency = currency;
		this.tagOwner = tagOwner;
		this.vehicle  = vehicle;
	}

	public void addScannedTag(ScannedTag scannedTag) {
		scannedTags.add(scannedTag);
	}

	public void removeScannedTag(ScannedTag scannedTag) {
		scannedTags.remove(scannedTag);
	}

	public Set<ScannedTag> getScannedTags() {
		return scannedTags.get();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public synchronized TagOwner getTagOwner() {
		return tagOwner;
	}

	public synchronized void setTagOwner(TagOwner tagOwner) {
		this.tagOwner = tagOwner;
	}

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized float getBalance() {
		return balance;
	}

	public synchronized void setBalance(float balance) {
		this.balance = balance;
	}

	public synchronized Currency getCurrency() {
		return currency;
	}

	public synchronized void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getData(){
		return this.id + "," + this.vehicle.getRegistrationNumber() + "," + this.tagOwner.getEmail() + "," + this.balance + "," + this.currency;
	}
}
