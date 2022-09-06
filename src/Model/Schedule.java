package Model;

import Enumerations.TypeOfShift;
import Property.SetProperty;
import Property.SetShifts;

import java.util.Set;

public class Schedule {
    private final SetShifts shifts = new SetShifts(this);

    public Schedule() {}

    public void addShift(Shift shift) {
        this.shifts.add(shift);
    }

    public void removeShift(Shift shift) {
        this.shifts.remove(shift);
    }

    public Set<Shift> getShifts() {
        return this.shifts.get();
    }
}
