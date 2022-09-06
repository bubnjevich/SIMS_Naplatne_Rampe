package Repository;

import Location.Place;
import Model.Failure;
import Model.TollBooth;
import Model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class FailuresRepository {
    private ArrayList<Failure> failures;
    private UserRepository userRepository;
    private TollBothRepository tollBothRepository;
    private final String FILENAME = "src/Data/failures.csv";
    private final String HEADER = "Header:Id,Email,TollBoothId,Description,ApplicationDate,RemovalDate";


    public FailuresRepository() {

        this.failures           = new ArrayList<Failure>();
        this.tollBothRepository = new TollBothRepository();
        this.userRepository     = new UserRepository();
        this.loadPlaces();
    }

    public ArrayList<Failure> getFailures() {
        return failures;
    }


    public void loadPlaces() {

        BufferedReader br = null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains("Header"))
                    continue;

                String[] lineSplit        = line.split(",");
                String id                 = lineSplit[0].trim();
                String email              = lineSplit[1].trim();
                String tollBoothId        = lineSplit[2].trim();
                String description        = lineSplit[3].trim();
                LocalDate applicationDate = LocalDate.parse(lineSplit[4].trim());
                LocalDate removalDate     = LocalDate.parse(lineSplit[5].trim());
                TollBooth tollBooth       = tollBothRepository.findTollBothById(tollBoothId);
                User user                 = userRepository.findUserByEmail(email);
                this.failures.add(new Failure(id,description,applicationDate,removalDate,tollBooth,user));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public Failure findFailureById(String id) {
        for (Failure failure : this.failures) {
            if (Objects.equals(failure.getId(), id))
                return failure;
        }
        return null;
    }

    public void saveFailures() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(Failure failure:this.failures) {
                writer.println(failure.getData());
            }
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

    }
}
