package Repository;

import Location.Address;
import Location.TollStation;
import Model.RoadSection;
import Model.TagOwner;

import java.io.*;
import java.util.ArrayList;

public class RoadSectionRepository {
    private ArrayList<RoadSection> roadSections;
    private TollStationRepository tollStationRepository;
    private final String FILENAME = "src/Data/sections.csv";
    private final String HEADER   = "Header: imeUlazneStanice, imeIzlazneStanice,duzina";

    public RoadSectionRepository() {
        this.roadSections          = new ArrayList<RoadSection>();
        this.tollStationRepository = new TollStationRepository();
        loadRoadSections();
    }

    public ArrayList<RoadSection> getRoadSections() {
        return roadSections;
    }

    public RoadSection findRoadSectionByStationNames(String entryName,String exitName){
        for(RoadSection roadSection:this.roadSections)
            if ((roadSection.getStartTollStation().getName().equals(entryName) && roadSection.getEndTollStation().getName().equals(exitName)))
                return roadSection;

        return null;
    }

    public void loadRoadSections() {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit = line.split(",");
                String entryStationName       = lineSplit[0].trim();
                String exitStationName        = lineSplit[1].trim();
                double roadLen                = Double.parseDouble(lineSplit[2].trim());
                TollStation entryTollStation  = tollStationRepository.findTollStationByName(entryStationName);
                TollStation exitTollStation   = tollStationRepository.findTollStationByName(exitStationName);
                this.roadSections.add(new RoadSection(roadLen,entryTollStation,exitTollStation));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTagOwners() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(RoadSection roadSection:this.roadSections)
                writer.println(roadSection.getData());

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
