package Model;

import Location.TollStation;
import Property.SetProperty;
import java.util.Set;

//TODO: DEONICE

public class TollBooth {
	private String id;
    private TollStation tollStation;
    private int isWorking;
    private final SetProperty<Pass> passes = new SetProperty<>();
    private final SetProperty<Failure> failures = new SetProperty<>();

    public TollBooth(String id, TollStation tollStation) {
    	this.id          = id;
        this.tollStation = tollStation;
        this.isWorking   = 0;

    }
    public TollBooth(String id, TollStation tollStation,int isWorking) {
        this.id          = id;
        this.tollStation = tollStation;
        this.isWorking   = isWorking;

    }

    public int getIsWorking() {return isWorking;}

    public void addFailure(Failure failure) {
        failures.add(failure);
    }

    public void removeFailure(Failure failure) {
        failures.remove(failure);
    }

    public Set<Failure> getFailures() {
        return failures.get();
    }

    public void addPass(Pass pass) {
        passes.add(pass);
    }

    public void removePass(Pass pass){
        passes.remove(pass);
    }

    public Set<Pass> getPasses() {
        return passes.get();
    }
    
    public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

    public TollStation getTollStation() {
        return tollStation;
    }

    public void setTollStation(TollStation tollStation) {
        if (null != this.tollStation && !this.tollStation.equals(tollStation))
            this.tollStation.removeTollBooth(this);
        this.tollStation = tollStation;
        if (null != tollStation)
            tollStation.addTollBooth(this);
    }
    public String getData(){
        return this.id + "," + this.tollStation.getName() + "," + this.isWorking;
    }

    public void reportFailure() {};

    public void setIsWorking(int isWorking) {
        this.isWorking = isWorking;
    }

}
