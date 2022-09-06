package Service;

import Model.User;
import Model.Vehicle;
import Repository.UserRepository;
import Repository.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(){
        this.vehicleRepository = new VehicleRepository();

    }

    public Vehicle findVehicle(String plateNum){
        for(Vehicle vehicle:this.vehicleRepository.getVehicles()){
            if(vehicle.getRegistrationNumber().equals(plateNum))
                return vehicle;
        }
        return null;
    }

}
