package Property;

import Model.Schedule;
import Model.Shift;

public class SetShifts extends SetProperty<Shift> {
    private final Schedule schedule;

    public SetShifts(Schedule schedule) {
        this.schedule = schedule;

    }

    public Boolean add(Shift shift) {
        boolean added = super.add(shift);
        if (added)
            shift.addSchedule(this.schedule);
        return added;
    }

    public Boolean remove(Shift shift) {
        boolean removed = super.remove(shift);
        if (removed)
            shift.removeSchedule(this.schedule);
        return removed;
    }


}
