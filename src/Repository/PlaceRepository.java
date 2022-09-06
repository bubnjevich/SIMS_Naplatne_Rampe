package Repository;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Place;
import Model.*;

import java.io.*;
import java.util.ArrayList;

public class PlaceRepository {
    private ArrayList<Place> places;
    private final String FILENAME = "src/Data/places.csv";
    private final String HEADER = "Header:Zipcode,PlaceName";


    public PlaceRepository() {

        this.places = new ArrayList<Place>();
        this.loadPlaces();
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public Place findPlaceByZipCode(String zipCode){
        for(Place place:this.places){
            if(place.getZipCode().equals(zipCode)){
                return place;
            }
        }
        return null;

    }

    public void loadPlaces() {

        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit = line.split(",");
                String zipCode     = lineSplit[0].trim();
                String name        = lineSplit[1].trim();
                this.places.add(new Place(name,zipCode));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void savePlaces() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(Place place:this.places) {
  //              writer.println(place.getData());
            }
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }
}
