package Model;

public class Identification {
    Pass pass;

    public Identification() {

    }
    public Identification(Pass pass) {
        this.pass = pass;
    }

    public Pass getPass() {
        return pass;
    }

    public Identification setPass(Pass pass) {
        this.pass = pass;
        return this;
    }
}
