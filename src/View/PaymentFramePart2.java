package View;

import Enumerations.TypeOfPass;
import Enumerations.TypeOfVehicle;
import Location.TollStation;
import Model.Pass;
import Model.Penalty;
import Model.Report;
import Prices.PriceListItem;
import Repository.PassesRepository;
import Repository.ReportRepository;
import Service.PriceService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentFramePart2 extends JFrame {
    private JLabel lblRegistrationPlate;

    private JLabel lblEntryTime;
    private JLabel lblEntryStation;
    private JLabel lblPrice;
    private JLabel lblPayment = new JLabel("Payment");
    private JTextField txtPayment=new JTextField(20);
    private JButton btnConfirm= new JButton("Confirm");
    private JButton btnCancel= new JButton("Cancel");
    private Pass pass;
    private TollStation tollStation;
    private PriceListItem priceListItem;
    private double len;
    private PassesRepository passesRepository;
    private ReportRepository reportRepository;
    public PaymentFramePart2(Pass pass, TollStation tollStation, PriceListItem priceListItem,double len) {
        setTitle("Payment");
        this.pass                 = pass;
        this.tollStation          = tollStation;
        this.priceListItem        = priceListItem;
        this.passesRepository = new PassesRepository();
        this.reportRepository = new ReportRepository();
        this.len = len;
        if(pass.getVehicle().getRegistrationNumber() == null){
            this.lblRegistrationPlate = new JLabel("Registration number: UNKNOWN");

        }else{
            this.lblRegistrationPlate = new JLabel("Registration number: " + pass.getVehicle().getRegistrationNumber());

        }
        this.lblEntryTime = new JLabel("Entry time: "+ pass.getDatetime());
        this.lblEntryStation = new JLabel("Entry station: "+ pass.getDatetime());
        this.lblPrice = new JLabel("Price: "+ priceListItem.getrsd());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();
    }
    public void initGui() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(this.lblRegistrationPlate);
        add(new JLabel());
        add(this.lblEntryTime);
        add(new JLabel());
        add(this.lblPrice);
        add(new JLabel());

        add(lblPayment);
        add(txtPayment);

        add(new JLabel());
        add(btnConfirm,"split 2");
        add(btnCancel);

        btnConfirm.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double change = Double.parseDouble(txtPayment.getText()) - priceListItem.getrsd();
                Duration duration = Duration.between(pass.getDatetime(), LocalDateTime.now());
                Pass exit = new Pass(TypeOfPass.EXIT,LocalDateTime.now(),pass.getId(),tollStation,pass.getVehicle());
                System.out.println(pass.getId());
                System.out.println(exit.getId());
                Report report = new Report(LocalDateTime.now(),priceListItem.getrsd(),pass,exit,pass.getVehicle().getRegistrationNumber());
                reportRepository.getReports().add(report);
                reportRepository.saveReports();
                passesRepository.getPasses().add(exit);
                passesRepository.savePasses();
                if(duration.toMinutes()<len/130){
                    JOptionPane.showMessageDialog(null, "PENALTYYY","POLICE",JOptionPane.INFORMATION_MESSAGE);
                }
                LiftTollRamp liftTollRamp = new LiftTollRamp(pass,tollStation,priceListItem,change);
                liftTollRamp.setVisible(true);
                dispose();

            }
        });

        btnCancel.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
