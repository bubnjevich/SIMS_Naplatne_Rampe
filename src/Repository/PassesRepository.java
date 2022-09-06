package Repository;

import Archives.Tag;
import Enumerations.TypeOfPass;
import Location.TollStation;
import Model.Pass;
import Model.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PassesRepository {
    private final ArrayList<Pass> passes;
    private final TollStationRepository tollStationRepository;
    private final VehicleRepository vehicleRepository;
    private final String FILENAME = "src/Data/passes.csv";
    private final String HEADER = "Header:Id,Station,Registration number,DateTime,Entry/Exit";
    DateTimeFormatter FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public PassesRepository() {
        this.vehicleRepository = new VehicleRepository();
        this.tollStationRepository = new TollStationRepository();
        this.passes = new ArrayList<Pass>();
        loadPasses();
    }

    public ArrayList<Pass> findPassesByID(String id) {
        ArrayList<Pass> passesList = new ArrayList<>();
        for (Pass pass : passes) {
            if (pass.getId().equals(id))
                passesList.add(pass);
            if (passesList.size() == 2)
                return passesList;
        }
        return passesList;
    }

    public Pass findPassByID(String id) {
        for (Pass pass : this.passes) {
            if (pass.getId().equals(id) && pass.getType() == TypeOfPass.ENTRY)
                return pass;
        }
        return null;
    }

    public Pass findPassByIDAndType(String id,TypeOfPass typeOfPass) {
        for (Pass pass : this.passes) {
            if (pass.getId().equals(id) && pass.getType() == typeOfPass)
                return pass;
        }
        return null;
    }

    public void loadPasses() {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if (line.contains(HEADER))
                    continue;

                String[] lineSplit = line.split(",");
                String id = lineSplit[0].trim();
                String stationStr = lineSplit[1].trim();
                TollStation station = tollStationRepository.findTollStationByName(stationStr);
                String registrationPlate = lineSplit[2].trim();
                Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registrationPlate);
                LocalDateTime date = LocalDateTime.parse(lineSplit[3].trim(), FORMATTER);
                TypeOfPass typeOfPass = TypeOfPass.valueOf(lineSplit[4].trim());
                this.passes.add(new Pass(typeOfPass ,date, id, station,vehicle));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void savePasses() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(Pass pass:this.passes) {
                writer.println(pass.getData());

            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

            e.printStackTrace();
        }


    }

    public ArrayList<Pass> getPasses() {
        return passes;
    }

    public String getFILENAME() {
        return FILENAME;
    }
}
