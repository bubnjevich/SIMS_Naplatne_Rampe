package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    private LocalDateTime localDateTime;
    private double amount;
    private Pass entry;
    private Pass exit;
    private String registrationPlate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public Report(LocalDateTime localDateTime, double amount, Pass entry, Pass exit, String registrationPlate) {
        this.localDateTime = localDateTime;
        this.amount = amount;
        this.entry = entry;
        this.exit = exit;
        this.registrationPlate = registrationPlate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }
    public String getData(){
        return this.amount + "," + this.entry.getid() + "," + this.exit.getid() + "," + this.registrationPlate + "," + this.localDateTime.format(formatter);
    }
}
