package Model;

public class OpticallyReadRegistration {
    private String registration;
    private Boolean successfully;
    private Pass pass;

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Boolean getSuccessfully() {
        return successfully;
    }

    public void setSuccessfully(Boolean successfully) {
        this.successfully = successfully;
    }
}
