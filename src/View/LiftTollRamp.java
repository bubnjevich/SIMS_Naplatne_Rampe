package View;

import Enumerations.TypeOfPass;
import Location.TollStation;
import Model.Pass;
import Model.Report;
import Prices.PriceListItem;
import Repository.PassesRepository;
import Repository.ReportRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class LiftTollRamp extends JFrame{
    private JLabel lblRegistrationPlate;

    private JLabel lblEntryTime;
    private JLabel lblEntryStation;
    private JLabel lblchange;
    private double change;
    private JButton btnConfirm= new JButton("LiftRamp");
    private JButton btnCancel= new JButton("PutDownRamp");
    private Pass pass;
    private TollStation tollStation;
    private PriceListItem priceListItem;
    private PassesRepository passesRepository;
    private ReportRepository reportRepository;
    public LiftTollRamp(Pass pass, TollStation tollStation, PriceListItem priceListItem,double change) {
        setTitle("Payment");
        this.change = change;
        this.pass                 = pass;
        this.tollStation          = tollStation;
        this.priceListItem        = priceListItem;
        this.passesRepository = new PassesRepository();
        this.reportRepository = new ReportRepository();
        this.lblchange = new JLabel("Change: "+ change);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();
    }
    public void initGui() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(this.lblchange);
        add(new JLabel());

        add(new JLabel());
        add(btnConfirm,"split 2");
        add(btnCancel);

        btnConfirm.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Toll Ramp is up","toll ramp",JOptionPane.INFORMATION_MESSAGE);



            }
        });

        btnCancel.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Toll Ramp is down","toll ramp",JOptionPane.INFORMATION_MESSAGE);
                PassByIdFrame passByIdFrame = new PassByIdFrame(tollStation);
                passByIdFrame.setVisible(true);
                dispose();
            }
        });
    }
}
