package Biling;

import Model.Pass;
import Prices.PriceListItem;

import java.util.Date;

public class Payment {
    private Date date;
    private Pass entrance;
    private Pass exit;
    private PriceListItem item;


    public Pass getEntrance() {
        return entrance;
    }

    public Pass getExit() {
        return exit;
    }

    public PriceListItem getItem() {
        return item;
    }

    public void setItem(PriceListItem item) {
        this.item = item;
    }

    public void setExit(Pass exit) {
        this.exit = exit;
    }

    public void setEntrance(Pass entrance) {
        this.entrance = entrance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void CalculateAverageSpeed() {

    }

    public void InformPoliceAboutOffence() {

    }
}
