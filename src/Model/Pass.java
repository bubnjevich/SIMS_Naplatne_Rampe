package Model;

import Biling.Payment;
import Enumerations.TypeOfPass;
import Location.TollStation;
import Property.SetProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class Pass {
    private TypeOfPass type;
    private LocalDateTime datetime;
    private String id;
    private TollStation tollStation;
    private Vehicle vehicle;
    private Payment payment;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final SetProperty<OpticallyReadRegistration> readRegistrations = new SetProperty<>();

    public void addOpticallyReadRegistration(OpticallyReadRegistration op) {
        readRegistrations.add(op);
    }

    public void removeOpticallyReadRegistration(OpticallyReadRegistration op) {
        readRegistrations.remove(op);
    }

    public Set<OpticallyReadRegistration> getRegistrations() {
        return readRegistrations.get();
    }

    public Pass(TypeOfPass type, LocalDateTime datetime, String id, TollStation tollStation, Payment payment) {
        this.type = type;
        this.datetime = datetime;
        this.id = id;
        this.tollStation = tollStation;
        this.payment = payment;
    }

    public Pass(TypeOfPass type, LocalDateTime datetime, String id, TollStation tollStation, Vehicle vehicle) {
        this.type = type;
        this.datetime = datetime;
        this.id = id;
        this.tollStation = tollStation;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTollStation(TollStation tollStation) {
        this.tollStation = tollStation;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TollStation getTollStation() {
        return tollStation;
    }

    public TypeOfPass getType() {
        return type;
    }

    public void setType(TypeOfPass type) {
        this.type = type;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public SetProperty<OpticallyReadRegistration> getReadRegistrations() {
        return readRegistrations;
    }

    public String getData(){
        return this.id + "," + this.tollStation.getName() + "," + this.getVehicle().getRegistrationNumber() + "," + this.getDatetime().format(formatter) + "," + this.getType();
    }
}
