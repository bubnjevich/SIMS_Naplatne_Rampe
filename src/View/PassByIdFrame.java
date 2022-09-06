package View;

import Location.TollStation;
import Model.Pass;
import Model.TollBooth;
import Repository.PassesRepository;
import Repository.TollBothRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassByIdFrame extends JFrame{

    private JLabel lblId = new JLabel("Id");
    private JTextField txtId=new JTextField(20);
    private JButton btnFind= new JButton("Choose");
    private JButton btnCancel= new JButton("Cancel");
    private TollStation tollStation;
    private PassesRepository passesRepository;
    public PassByIdFrame(TollStation tollStation) {
        this.tollStation=tollStation;
        this.passesRepository = new PassesRepository();
        setTitle("Find pass by id");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();
    }
    public void initGui() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblId);
        add(txtId);
        add(new JLabel());
        add(btnFind,"split 2");
        add(btnCancel);

        btnFind.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Pass pass = passesRepository.findPassByID(txtId.getText());
                PaymentFrame paymentFrame = new PaymentFrame(pass,tollStation);
                paymentFrame.setVisible(true);
                setVisible(false);
            }
        });

        btnCancel.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
