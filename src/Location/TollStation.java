package Location;

import Model.RoadSection;
import Model.TollBooth;
import Property.SetProperty;

import java.util.Set;

public class TollStation {
    private String name;
    private Place place;
    private final SetProperty<TollBooth> tollBooths = new SetProperty<>();



    public TollStation(String name, Place place) {
        this.name  = name;
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public TollStation setName(String name) {
        this.name = name;
        return this;
    }

    public TollStation setPlace(Place place) {
        this.place = place;
        return this;
    }

    public void addTollBooth(TollBooth tollBooth) {
        this.tollBooths.add(tollBooth);
    }

    public void removeTollBooth(TollBooth tollBooth) {
        this.tollBooths.remove(tollBooth);
    }

    public Set<TollBooth> getTollBooths() {
        return this.tollBooths.get();
    }

    public String getData(){
        return this.name + "," + this.place.getZipCode();
    }
}
