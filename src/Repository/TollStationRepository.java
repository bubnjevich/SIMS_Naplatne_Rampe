package Repository;

import Location.Place;
import Location.TollStation;
import Model.TollBooth;

import java.io.*;
import java.util.ArrayList;

public class TollStationRepository {
    private ArrayList<TollStation> tollStations;
    private PlaceRepository placeRepository;
    private TollBothRepository tollBothRepository;
    private final String FILENAME = "src/Data/stations.csv";
    private final String HEADER = "Header: name,Place";


    public TollStationRepository() {

        this.tollStations    = new ArrayList<TollStation>();
        this.placeRepository = new PlaceRepository();
        this.loadTollStations();
    }

    public ArrayList<TollStation> getTollStations() {
        return tollStations;
    }

    public TollStation findTollStationByName(String name){
        for(TollStation tollStation:this.tollStations){
            if(tollStation.getName().equals(name)){
                return tollStation;
            }
        }
        return null;
    }

    public void RemoveTollStation(TollStation tollStation) {
        String old = tollStation.getName();
        tollStation.setName("~" + tollStation.getName());
        this.tollBothRepository = new TollBothRepository();
        tollBothRepository.RemoveTollBooths(old);

        saveTollStations();
        this.tollStations.remove(tollStation);
    }

    public void AddTollStation(TollStation tollStation) {
        this.tollStations.add(tollStation);
        saveTollStations();
    }



    public void loadTollStations() {
        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit = line.split(",");
                String name          = lineSplit[0].trim();
                String zipCode     = lineSplit[1].trim();
                Place place = placeRepository.findPlaceByZipCode(zipCode);
                this.tollStations.add(new TollStation(name,place));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void saveTollStations() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(TollStation tollStation:this.tollStations) {
                writer.println(tollStation.getData());
            }
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }
}
