package ViewMainFrames;

import Model.BilingOfficer;
import View.ChooseBothToll;
import View.FailureFrame;
import View.LoginFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BilingOfficerFrame extends JFrame {


    private JButton btnTollBooth         = new JButton("      Toll Both      ");
    private JButton btnReportDamage   = new JButton("Report damage");
    private JButton btnLogout         = new JButton("      LogOut      ");

    JPanel panel                      = new JPanel();
    private BilingOfficer billingOfficer;

    public BilingOfficerFrame(BilingOfficer billingOfficer) {
        this.billingOfficer = billingOfficer;
        setTitle("Welcome " + billingOfficer.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,300);
        setResizable(false);

        btnTollBooth.setPreferredSize(new Dimension(40, 20));
        btnReportDamage.setPreferredSize(new Dimension(60, 20));
        btnLogout.setPreferredSize(new Dimension(60, 20));

        panel.setLayout(new MigLayout("wrap 1"));

        panel.add(btnTollBooth);
        panel.add(btnReportDamage);
        panel.add(btnLogout);

        add(panel,BorderLayout.CENTER);
        pack();

        btnTollBooth.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ChooseBothToll toll = new ChooseBothToll(billingOfficer);
                toll.setVisible(true);
            }
        });

        btnReportDamage.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                FailureFrame failureFrame = new FailureFrame(billingOfficer);
                failureFrame.setVisible(true);
            }

        });

        btnLogout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                dispose();
            }

        });

    }
}
