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

	}
}
