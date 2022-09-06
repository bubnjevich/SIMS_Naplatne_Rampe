package Model;

import Enumerations.TypeOfShift;
import Property.SetProperty;

import java.util.Date;
import java.util.Set;

public class Shift {
    private Date date;
    private TypeOfShift type;
    private final SetProperty<Schedule> schedules = new SetProperty<>();

    public Shift(Date date, TypeOfShift type) {
        this.date = date;
        this.type = type;

    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        this.schedules.remove(schedule);
    }

    public Set<Schedule> getSchedules() {
        return this.schedules.get();
    }

    public Date getDate() {
        return date;
    }

    public TypeOfShift getType() {
        return type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(TypeOfShift type) {
        this.type = type;
    }
}
