package Repository;

import Archives.Tag;
import Enumerations.TypeOfVehicle;
import Location.Address;
import Model.TagOwner;
import Model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class TagOwnerRepository {

    private ArrayList<TagOwner> tagOwners;
    private final String FILENAME = "src/Data/tagowners.csv";
    private final String HEADER   = "Header:Email,Name,Lastname,Phonenumber,Address";

    public TagOwnerRepository() {
        this.tagOwners = new ArrayList<TagOwner>();
    }

    public ArrayList<TagOwner> getTagOwners() {
        return tagOwners;
    }

    public TagOwner findTagOwnerByEmail(String email){
        for(TagOwner tagOwner:tagOwners){
            if(tagOwner.getEmail().equals(email))
                return tagOwner;
        }
        return null;
    }
    public void loadTagOwners() {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit = line.split(",");
                String email       = lineSplit[0].trim();
                String name        = lineSplit[1].trim();
                String lastName    = lineSplit[2].trim();
                String phoneNum    = lineSplit[3].trim();
                String street      = lineSplit[4].trim();
                Address address    = new Address(street);
                this.tagOwners.add(new TagOwner(email,name,lastName,phoneNum,address));
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
            for(TagOwner tagOwner:this.tagOwners)
                writer.println(tagOwner.getData());

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}