package Repository;

import Enumerations.TypeOfVehicle;
import Location.Address;
import Model.RoadSection;
import Prices.PriceListItem;

import java.io.*;
import java.util.ArrayList;

public class PriceListRepository {
    private ArrayList<PriceListItem> priceListItems;
    private final String FILENAME = "src/Data/priceList.csv";
    private RoadSectionRepository roadSectionRepository;

    private final String HEADER   = "Header:Station,TypeOfVechile,RSD,EUR";

    public PriceListRepository() {
        this.priceListItems        = new ArrayList<PriceListItem>();
        this.roadSectionRepository = new RoadSectionRepository();
        this.loadPriceListItems();
    }

    public ArrayList<PriceListItem> getPriceLists() {
        return priceListItems;
    }

    public void loadPriceListItems() {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {
                if(line.contains(HEADER))
                    continue;
                String[] lineSplit = line.split(",");
                String entryExitNames       = lineSplit[0].trim();
                TypeOfVehicle typeOfVehicle = TypeOfVehicle.valueOf(lineSplit[1].trim());
                double rsd                  = Double.parseDouble(lineSplit[2].trim());
                double eur                  = Double.parseDouble(lineSplit[3].trim());

                String[] sections           = entryExitNames.split("-");
                String   entryName          = sections[0].trim();
                String   exitName           = sections[1].trim();
                RoadSection roadSection     = roadSectionRepository.findRoadSectionByStationNames(entryName,exitName);

                this.priceListItems.add(new PriceListItem(rsd,eur,typeOfVehicle,roadSection));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePriceLists() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(PriceListItem priceListItem:this.priceListItems)
                writer.println(priceListItem.getData());

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
