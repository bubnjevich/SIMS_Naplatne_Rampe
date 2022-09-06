package Prices;


import Enumerations.TypeOfVehicle;
import Model.RoadSection;

public class PriceListItem {
    private double rsd;
    private double eur;
    private TypeOfVehicle typeOfVehicle;
    private RoadSection roadSection;

    public PriceListItem(double rsd, double eur, TypeOfVehicle typeOfVehicle, RoadSection roadSection) {
        this.rsd        = rsd;
        this.eur      = eur;
        this.typeOfVehicle = typeOfVehicle;
        this.roadSection   = roadSection;
    }

    public double getrsd() {
        return rsd;
    }

    public void setrsd(double rsd) {
        this.rsd = rsd;
    }

    public double geteur() {
        return eur;
    }

    public void seteur(double eur) {
        this.eur = eur;
    }

    public RoadSection getRoadSection() {
        return roadSection;
    }

    public void setRoadSection(RoadSection roadSection) {
        if (null != this.roadSection && this.roadSection.equals(roadSection))
            this.roadSection.removePriceListItem(this);
        this.roadSection = roadSection;
        if (null != roadSection)
            roadSection.addPriceListItem(this);    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getData(){
        return this.getRoadSection().getStartTollStation().getName() + "-"+ this.getRoadSection().getEndTollStation().getName() + "," + this.getTypeOfVehicle() + "," + this.getrsd() + "," + this.geteur();
    }
}
