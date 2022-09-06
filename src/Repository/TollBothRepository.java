package Repository;

import Location.Place;
import Location.TollStation;
import Model.Failure;
import Model.TollBooth;

import java.io.*;
import java.util.ArrayList;

public class TollBothRepository {
    private ArrayList<TollBooth> tollBooths;
    private TollStationRepository tollStationRepository;
    private final String FILENAME = "src/Data/tollbooths.csv";
    private final String HEADER = "Header: tollBoothNumber,station name";


    public TollBothRepository() {

        this.tollBooths            = new ArrayList<TollBooth>();
        this.tollStationRepository = new TollStationRepository();
        this.loadTollBooths();
    }

    public ArrayList<TollBooth> getTollBooths() {
        return tollBooths;
    }

    public TollBooth findTollBothById(String id){
        for(TollBooth tollBooth:this.tollBooths){
            if(tollBooth.getId().trim().equals(id.trim())){
                return tollBooth;
            }
        }
        return null;
    }

    public void AddToolBooth(TollBooth tollBooth) {
        this.tollBooths.add(tollBooth);
        saveTollBooths();
    }

    public void RemoveToolBooth(TollBooth tollBooth) {
        tollBooth.setId("~" + tollBooth.getId());
        saveTollBooths();
        this.tollBooths.remove(tollBooth);

    }

    public void RemoveTollBooths(String deletedStation) {

        for (TollBooth tb : this.tollBooths) {
            if (tb.getTollStation().getName().equals(deletedStation)) {
                tb.getTollStation().setName("~" + deletedStation);
            }
        }
        saveTollBooths();
    }


    public void loadTollBooths() {
        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit      = line.split(",");
                String id               = lineSplit[0].trim();
                String name             = lineSplit[1].trim();
                TollStation tollStation = tollStationRepository.findTollStationByName(name);
                int isWorking           = Integer.parseInt(lineSplit[2].trim());
                this.tollBooths.add(new TollBooth(id,tollStation,isWorking));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void saveTollBooths() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(TollBooth tollBooth:this.tollBooths) {
                writer.println(tollBooth.getData());
            }
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
    }
}
