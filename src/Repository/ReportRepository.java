package Repository;

import Enumerations.TypeOfPass;
import Location.TollStation;
import Model.Pass;
import Model.Report;
import Model.RoadSection;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportRepository {
    private ArrayList<Report> reports;

    private final String FILENAME = "src/Data/reports.csv";
    private final String HEADER   = "Header:Amount,Entry,Exit,RegistrationPlate,LocalDateTime";
    private PassesRepository passesRepository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ReportRepository() {
        this.reports          = new ArrayList<Report>();
        this.passesRepository = new PassesRepository();

        loadReports();
    }

    public ArrayList<Report> getReports() {
        return reports;
    }


    public void loadReports() {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {

                if(line.contains(HEADER))
                    continue;
                //Header:Amount,Entry,Exit,RegistrationPlate,LocalDateTime
                String[] lineSplit  = line.split(",");
                Double amount       = Double.parseDouble(lineSplit[0].trim());
                String entry        = lineSplit[1].trim();
                String exit         = lineSplit[2].trim();
                String registration = lineSplit[3].trim();
                Pass passentry = passesRepository.findPassByIDAndType(entry, TypeOfPass.ENTRY);
                Pass passexit = passesRepository.findPassByIDAndType(exit, TypeOfPass.EXIT);
                LocalDateTime localDateTime  = LocalDateTime.parse(lineSplit[4].trim(),formatter);
                this.reports.add(new Report(localDateTime,amount,passentry,passexit,registration));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveReports() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME, "UTF-8");
            writer.println(HEADER);
            for(Report report:this.reports)
                writer.println(report.getData());

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
