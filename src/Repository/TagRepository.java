package Repository;

import Archives.Tag;
import Enumerations.Currency;
import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;
import Location.Place;
import Model.*;

import java.io.*;
import java.util.ArrayList;

public class TagRepository {
    private ArrayList<Tag> tags;
    private VehicleRepository vehicleRepository;
    private TagOwnerRepository tagOwnerRepository;

    private final String FILENAME = "src/Data/tags.csv";
    private final String HEADER = "Header:Email,Name,Lastname,Phonenumber,Address,Role";

    public TagRepository() {

        this.tags              = new ArrayList<Tag>();
        this.tagOwnerRepository    = new TagOwnerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.loadTags();
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void loadTags() {

        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;
                String[] lineSplit        = line.split(",");
                String id                 = lineSplit[0].trim();
                String registrationNumber = lineSplit[1].trim();
                String email              = lineSplit[2].trim();
                int balance               = Integer.parseInt(lineSplit[3].trim());
                Currency currency         = Currency.valueOf(lineSplit[4].trim());
                TagOwner tagOwner         = tagOwnerRepository.findTagOwnerByEmail(email);
                Vehicle vehicle           = vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);
                this.tags.add(new Tag(id,balance,currency,tagOwner,vehicle));
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
            for(Tag tag:this.tags) {
                writer.println(tag.getData());

            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {

            e.printStackTrace();
        }


    }
}
