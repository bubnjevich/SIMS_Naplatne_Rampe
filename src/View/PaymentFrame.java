package View;

import Enumerations.Gender;
import Enumerations.TypeOfVehicle;
import Location.TollStation;
import Model.Pass;
import Model.RoadSection;
import Model.Vehicle;
import Prices.PriceListItem;
import Service.PriceService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentFrame extends JFrame {
    private JLabel lblRegistrationPlate;

    private JLabel lblEntryTime;
    private JLabel lblEntryStation;

    private JLabel lblTypeOfVehicle = new JLabel("Type of vehicle");
    private TypeOfVehicle[] typeOfVehicles = {TypeOfVehicle.MOTORBIKE, TypeOfVehicle.PASSENGER_CAR, TypeOfVehicle.PICKUP, TypeOfVehicle.TOW_TRUCK, TypeOfVehicle.TRACTOR_TRAILER};
    private JComboBox<TypeOfVehicle> cbTypeOfVehicle = new JComboBox<TypeOfVehicle>(typeOfVehicles);


    private JButton btnConfirm = new JButton("Confirm");
    private JButton btnCancel = new JButton("Cancel");
    private Pass pass;
    private TollStation tollStation;
    private PriceService priceService;

    public PaymentFrame(Pass pass, TollStation tollStation) {
        setTitle("Payment");
        this.pass = pass;
        this.tollStation = tollStation;
        this.priceService = new PriceService();
        if(pass.getVehicle().getRegistrationNumber() == null){
            this.lblRegistrationPlate = new JLabel("Registration number: UNKNOWN");

        }else{
            this.lblRegistrationPlate = new JLabel("Registration number: " + pass.getVehicle().getRegistrationNumber());

        }
        this.lblEntryTime = new JLabel("Entry time: " + pass.getDatetime());
        this.lblEntryStation = new JLabel("Entry station: " + pass.getDatetime());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();

        btnConfirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                PriceListItem priceListItem = priceService.findPriceListItemByEntryExit(pass.getTollStation().getName() + "-" + tollStation.getName(), (TypeOfVehicle) cbTypeOfVehicle.getSelectedItem());
                double len = priceService.findRoadSectionByEntryexit(pass.getTollStation().getName(),tollStation.getName());
                PaymentFramePart2 paymentFramePart2 = new PaymentFramePart2(pass, tollStation, priceListItem,len);
                paymentFramePart2.setVisible(true);
                dispose();

            }
        });

        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void initGui() {
        MigLayout mig = new MigLayout("wrap 2");
        setLayout(mig);
        add(this.lblRegistrationPlate);
        add(new JLabel());
        add(this.lblEntryTime);
        add(new JLabel());

        add(lblTypeOfVehicle);
        add(cbTypeOfVehicle);

        add(new JLabel());
        add(btnConfirm, "split 2");
        add(btnCancel);


    }
}
