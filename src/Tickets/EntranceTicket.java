package Tickets;

import Model.Identification;
import Model.Vehicle;

public class EntranceTicket extends Identification {
    private Vehicle vehicle;

    public EntranceTicket(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (null != this.vehicle && this.vehicle.equals(vehicle))
            this.vehicle.removeEntranceTicket(this);
        this.vehicle = vehicle;
        if (null != vehicle)
            vehicle.addEntranceTicket(this);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
