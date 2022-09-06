import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;
import Location.TollStation;
import Model.Pass;
import Model.RoadSection;
import Model.TagSeller;
import Model.User;
import Prices.PriceListItem;
import Repository.PassesRepository;
import Repository.PriceListRepository;
import Repository.RoadSectionRepository;
import Repository.TollStationRepository;
import Service.UserService;
import View.CreateUserFrame;
import View.LoginFrame;
import View.PaymentFrame;
import ViewMainFrames.BilingOfficerFrame;
import ViewMainFrames.ManagerTollStationFrame;
import ViewMainFrames.TagOwnerFrame;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		LoginFrame login = new LoginFrame();
		login.setVisible(true);
//		TollStationRepository to = new TollStationRepository();
//		TollStation tollstation = to.findTollStationByName("Station Novi Sad 1");
//
//		PassesRepository pas = new PassesRepository();
//		ArrayList<Pass> passe = pas.getPasses();
//
//		PaymentFrame login = new PaymentFrame(passe.get(0),tollstation);
//		login.setVisible(true);
//		Address adress = new Address("DDASDASDASDAS");
//		TagSeller user = new TagSeller("bane","des","des","des", Gender.MALE,"dsdasdas",adress, Role.TAGSELLER);
//
//		UserService userService = new UserService();
//		userService.createUser(user);
//		RoadSectionRepository rd = new RoadSectionRepository();
//		for (RoadSection road:rd.getRoadSections()){
//			System.out.println(road.getData());
//		}
//		PriceListRepository pr = new PriceListRepository();
//		for (PriceListItem pra:pr.getPriceLists()){
//			System.out.println(pra.getData());
//		}



	}
}
