package Service;

import Enumerations.TypeOfVehicle;
import Model.RoadSection;
import Model.User;
import Prices.PriceListItem;
import Repository.PriceListRepository;
import Repository.RoadSectionRepository;
import Repository.UserRepository;

public class PriceService {
    private PriceListRepository priceListRepository;
    private RoadSectionRepository roadSectionRepository;
    public PriceService(){
        this.priceListRepository   = new PriceListRepository();
        this.roadSectionRepository = new RoadSectionRepository();

    }

    public PriceListItem findPriceListItemByEntryExit(String entryExitString, TypeOfVehicle typeOfVehicle){
        String[] split      = entryExitString.split("-");
        String entry        = split[0].trim();
        String exit         = split[1].trim();
        System.out.println(entry);
        System.out.println(exit);

        System.out.println(this.priceListRepository.getPriceLists().size());
        for(PriceListItem priceListItem:this.priceListRepository.getPriceLists()) {
            if(priceListItem.getTypeOfVehicle() == typeOfVehicle && priceListItem.getRoadSection().getStartTollStation().getName().equals(entry) && priceListItem.getRoadSection().getEndTollStation().getName().equals(exit) )
                return priceListItem;

        }

        return null;
    }
    public double findRoadSectionByEntryexit(String entry,String exit){
        for(RoadSection roadSection:roadSectionRepository.getRoadSections()){
            if (roadSection.getStartTollStation().getName().equals(entry) && roadSection.getEndTollStation().getName().equals(exit))
                return roadSection.getLength();
        }
        return 0.0;

    }
}
