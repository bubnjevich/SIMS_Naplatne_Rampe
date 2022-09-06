package Service;

import Location.Place;
import Repository.PlaceRepository;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(){
        this.placeRepository = new PlaceRepository();

    }

    public Place findPlaceByZipcode(String zipcode){
        for(Place place:this.placeRepository.getPlaces()){
            if(place.getZipCode().equals(zipcode))
                return place;
        }
        return null;
    }

//    public void createUser(User user){
//        this.userRepository.getUsers().add(user);
//        this.userRepository.saveUsers();
//
//    }
}
