package Model;

import Location.TollStation;
import Prices.PriceListItem;
import Property.SetProperty;

import java.util.Set;

public class RoadSection {
    private double length;
    private TollStation startTollStation;
    private TollStation endTollStation;
    private final SetProperty<PriceListItem> items = new SetProperty<>();


    public RoadSection(double length) {
        this.length = length;
    }

    public RoadSection(double length, TollStation startTollStation, TollStation endTollStation) {
        this.length = length;
        this.startTollStation = startTollStation;
        this.endTollStation = endTollStation;
    }

    public void addPriceListItem(PriceListItem item) {
        this.items.add(item);
    }

    public void removePriceListItem(PriceListItem item) {
        this.items.remove(item);

    }

    public void setStartTollStation(TollStation startTollStation) {
        this.startTollStation = startTollStation;
    }

    public void setEndTollStation(TollStation endTollStation) {
        this.endTollStation = endTollStation;
    }

    public Set<PriceListItem> getPriceListItems() {
        return this.items.get();

    }

    public TollStation getStartTollStation() {
        return startTollStation;
    }

    public TollStation getEndTollStation() {
        return endTollStation;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getData(){
        return this.length + "," + startTollStation.getName() + "," + endTollStation.getName();
    }
}
