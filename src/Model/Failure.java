package Model;

import Property.SetProperty;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

public class Failure {
    private final String id;  
    private String description;
    private LocalDate dateOfDefect;
    private LocalDate dateOfRepair;
    private TollBooth tollBooth; 
    private User user;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public Failure(String id, String description, LocalDate dateOfDefect, TollBooth tollBooth, User user) {
        this.id           = id;
        this.description  = description;
        this.dateOfDefect = dateOfDefect;
        this.dateOfRepair = LocalDate.of(1111, 11, 11);;
        this.tollBooth    = tollBooth;
        this.user         = user;

    }
    
    public synchronized User getUser() {
		return user;
	}

    public synchronized void setUser(User user) {
		this.user = user;
	}

    public String getId() {
        return id;
    }

    public TollBooth getTollBooth() {
        return tollBooth;
    }

    public void setTollBooth(TollBooth tollBooth) {
        if (null != this.tollBooth && this.tollBooth.equals(tollBooth))
            this.tollBooth.removeFailure(this);
        this.tollBooth = tollBooth;
        if (null != tollBooth)
            tollBooth.addFailure(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfRepair() {
        return dateOfRepair;
    }

    public void setDateOfRepair(LocalDate dateOfRepair) {
        this.dateOfRepair = dateOfRepair;
    }

    public LocalDate getDateOfDefect() {
        return dateOfDefect;
    }

    public void setDateOfDefect(LocalDate dateOfDefect) {
        this.dateOfDefect = dateOfDefect;
    }

    public String getData(){
        return this.id + "," + this.user.getEmail() + "," + tollBooth.getId() + "," + this.description + "," + this.dateOfDefect.format(formatter) + "," + this.dateOfRepair.format(formatter);
    }

}
