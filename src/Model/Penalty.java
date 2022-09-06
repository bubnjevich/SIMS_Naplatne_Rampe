package Model;

public class Penalty {

    String registration;
    Pass entry;
    Pass exit;
    double amount;
    double vehicleSpeed;

    public Penalty(String registration, Pass entry, Pass exit,
                    double amount, double vehicleSpeed) {
        this.registration = registration;
        this.amount = amount;
        this.vehicleSpeed = vehicleSpeed;
        this.entry = entry;
        this.exit = exit;
    }




    public double getAmount() {
        return amount;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Pass getEntry() {
        return entry;
    }

    public void setEntry(Pass entry) {
        this.entry = entry;
    }

    public Pass getExit() {
        return exit;
    }

    public void setExit(Pass exit) {
        this.exit = exit;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(double vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }
}
