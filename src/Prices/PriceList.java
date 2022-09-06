package Prices;

import Property.SetProperty;

import java.util.Date;
import java.util.Set;

public class PriceList {
    private Date effectiveDate;
    private final SetProperty<PriceListItem> items = new SetProperty<>();

    public PriceList(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void addItem(PriceListItem priceListItem) {
        items.add(priceListItem);
    }

    public void removeItem(PriceListItem priceListItem) {
        items.remove(priceListItem);
    }

    public Set<PriceListItem> getItems() {
        return items.get();
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
