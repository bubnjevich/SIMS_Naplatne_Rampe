import Location.TollStation;
import Model.Pass;
import Model.User;
import Prices.PriceList;
import Property.SetProperty;

import java.util.Set;

public class PaymentSystem {
    private final SetProperty<User> users  = new SetProperty<User>();
    private final SetProperty<Pass> passes  = new SetProperty<Pass>();
    private final SetProperty<TollStation> tollStations  = new SetProperty<>();
    private final SetProperty<PriceList> prices  = new SetProperty<>();

    public PaymentSystem() {}

    public Set<User> getUsers() {
        return users.get();
    }

    public Set<Pass> getPasses() {
        return passes.get();
    }

    public Set<TollStation> getTollStations() {
        return tollStations.get();
    }

    public Set<PriceList> getPrices() {
        return prices.get();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void addPass(Pass pass) {
        this.passes.add(pass);
    }

    public void removePass(Pass pass) {
        this.passes.remove(pass);
    }

    public void addTollStation(TollStation tollStation) {
        this.tollStations.add(tollStation);
    }

    public void removeTollStation(TollStation tollStation) {
        this.tollStations.remove(tollStation);
    }

    public void addPrices(PriceList priceList) {
        this.prices.add(priceList);
    }

    public void removePrices(PriceList priceList) {
        this.prices.remove(priceList);
    }

}
