package Repository;

import Enumerations.TypeOfPass;
import Model.Pass;
import Model.Penalty;
import Model.Vehicle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PenaltyRepository {
    private final ArrayList<Penalty> penalties;
    private final PassesRepository passesRepository;
    private final String FILENAME = "src/Data/penalty.csv";

    public PenaltyRepository() {
        penalties = new ArrayList<>();
        passesRepository = new PassesRepository();
        loadData();
    }

    private void loadData() {
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if (line.contains("Header"))
                    continue;

                String[] lineSplit = line.split(",");
                ArrayList<Pass> passes = passesRepository.findPassesByID(lineSplit[0]);
                Pass entry;
                Pass exit;
                if (passes.get(0).getType() == TypeOfPass.ENTRY) {
                    entry = passes.get(0);
                    exit = passes.get(1);
                }
                else {
                    exit = passes.get(0);
                    entry = passes.get(1);
                }
                String description = lineSplit[1];
                double amount = Double.parseDouble(lineSplit[2]);
                int speed = Integer.parseInt(lineSplit[3]);
                Vehicle vehicle = passes.get(0).getVehicle();
                //this.penalties.add(new Penalty(vehicle, entry, exit, description, amount, speed));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Penalty> getPenalties() {
        return penalties;
    }

}
