package Model;

import Archives.ScannedTag;
import Archives.Tag;
import Enumerations.TypeOfVehicle;
import Property.SetProperty;
import Tickets.EntranceTicket;

import java.util.Set;

public class Vehicle { TypeOfVehicle type;
    String registrationNumber;
    private final SetProperty<EntranceTicket> entranceTickets = new SetProperty<>();

    public Vehicle(TypeOfVehicle type, String registrationNumber) {
        this.type               = type;
        this.registrationNumber = registrationNumber;
    }

    public TypeOfVehicle getType() {
        return type;
    }

    public void setType(TypeOfVehicle type) {
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void addEntranceTicket(EntranceTicket entranceTicket) {
        this.entranceTickets.add(entranceTicket);
    }

    public void removeEntranceTicket(EntranceTicket entranceTicket) {
        this.entranceTickets.remove(entranceTicket);
    }

    public Set<EntranceTicket> getEntranceTickets() {
        return entranceTickets.get();
    }

    public String getData(){
        return this.registrationNumber + "," + this.type;
    }

}
