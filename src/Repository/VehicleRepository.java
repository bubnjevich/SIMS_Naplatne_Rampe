package Repository;

import Enumerations.TypeOfVehicle;
import Model.Failure;
import Model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class VehicleRepository {

    private ArrayList<Vehicle> vehicles;
    private final String FILENAME = "src/Data/vehicle.csv";
    private final String HEADER   = "Header:Registration plate,Tagid,Type";
    public VehicleRepository() {
        this.vehicles = new ArrayList<Vehicle>();
        loadVechiles();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    public Vehicle findVehicleByRegistrationNumber(String registrationNumber){
        for(Vehicle vehicle:this.vehicles){
            if(vehicle.getRegistrationNumber().equals(registrationNumber))
                return vehicle;
        }
        return null;
    }
    public void loadVechiles() {

        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {
                if(line.contains("Registration"))
                    continue;

                String[] lineSplit          = line.split(",");
                String registrationPlate    = lineSplit[0].trim();
                TypeOfVehicle typeOfVechile = TypeOfVehicle.valueOf(lineSplit[1].trim());
                this.vehicles.add(new Vehicle(typeOfVechile,registrationPlate));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveVehicles() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(Vehicle vehicle:this.vehicles) {
                writer.println(vehicle.getData());
            }
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }



}