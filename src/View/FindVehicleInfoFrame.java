package View;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindVehicleInfoFrame extends JFrame {

    private JLabel lblRegistrationPlate = new JLabel("Registration Plate");
    private JTextField txtRegistrationPlate=new JTextField(20);

    private JLabel lblEntryTime = new JLabel("Entry time");
    private JTextField txtEntryTime = new JTextField(20);
    private JButton btnFind = new JButton("Find");
    private JButton btnCancel= new JButton("Cancel");

    public FindVehicleInfoFrame() {
        setTitle("Find tag by id");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();



        btnFind.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                txtRegistrationPlate.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(txtEntryTime.getText(), formatter);
//                PaymentFrame paymentFrame = new PaymentFrame()
                setVisible(false);
            }
        });


        btnCancel.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void initGui() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblRegistrationPlate);
        add(txtRegistrationPlate);
        add(lblEntryTime);
        add(txtEntryTime);
        add(new JLabel());
        add(btnFind,"split 2");
        add(btnCancel);
    }
}
