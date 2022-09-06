package Repository;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;
import Location.Place;
import Model.*;

import java.io.*;
import java.util.ArrayList;


public class UserRepository {
    private ArrayList<User> users;
    private PlaceRepository placeRepository;
    private final String FILENAME = "src/Data/users.csv";
    private final String HEADER = "Header:Email,Name,Lastname,Phonenumber,Address,Role";


    public UserRepository() {

        this.placeRepository = new PlaceRepository();
        this.users = new ArrayList<User>();
        this.loadUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    
    public User findUserByEmail(String email){
        for(User user:this.users) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void loadUsers() {

        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;
                String[] lineSplit = line.split(",");
                String email       = lineSplit[0].trim();
                String name        = lineSplit[1].trim();
                String lastName    = lineSplit[2].trim();
                Gender gender      = Gender.valueOf(lineSplit[3].trim());
                String password    = lineSplit[4].trim();
                String phoneNum    = lineSplit[5].trim();
                String streetName  = lineSplit[6].trim();
                String houseNum    = lineSplit[7].trim();
                String zipCode     = lineSplit[8].trim();
                String role        = lineSplit[9].trim();
                Place place        = this.placeRepository.findPlaceByZipCode(zipCode);
                Address address    = new Address(streetName,houseNum,place);
                switch (role.toLowerCase()) {
                    case "admin" ->
                            this.users.add(new Admin(name, lastName, email, password, gender, phoneNum, address, Role.ADMIN));
                    case "bilingofficer" ->
                            this.users.add(new BilingOfficer(name, lastName, email, password, gender, phoneNum, address, Role.BILINGOFFICER));
                    case "managertollstation" ->
                            this.users.add(new ManagerTollStation(name, lastName, email, password, gender, phoneNum, address, Role.MANAGERTOLLSTATION));
                    case "tagseller" ->
                            this.users.add(new TagSeller(name, lastName, email, password, gender, phoneNum, address, Role.TAGSELLER));
                    case "uppermanager" ->
                            this.users.add(new UpperManager(name, lastName, email, password, gender, phoneNum, address, Role.UPPERMANAGER));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(User user:this.users) {
                writer.println(user.getData());

            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

            e.printStackTrace();
        }


    }
}