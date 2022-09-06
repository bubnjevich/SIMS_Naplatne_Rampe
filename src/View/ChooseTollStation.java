package View;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseTollStation extends JFrame {

    private static final long serialVersionUID = -17676587391118465L;
    private JLabel lblTollStation        = new JLabel("Toll Station Name");
    private JTextField txtTollStation    = new JTextField(20);
    private JButton btnConfirm           = new JButton("Confirm");
    private JButton btnCancel            = new JButton("Cancel");

    public ChooseTollStation() {
        setTitle("Choose Toll Station");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGui();
        pack();

    }
    public void initGui() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblTollStation);
        add(txtTollStation);
        add(new JLabel());
        add(btnConfirm,"split 2");
        add(btnCancel);

        btnConfirm.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                txtTollStation.getText();
            }
        });

        btnCancel.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
    }
}



