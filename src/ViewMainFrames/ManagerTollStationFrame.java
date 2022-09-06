package ViewMainFrames;

import Model.ManagerTollStation;
import View.CreateUserFrame;
import View.LoginFrame;
import View.ViewTollStations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerTollStationFrame extends JFrame {
    private JButton btncreateUser         = new JButton("   Create User  ");
    private JButton btnAllTollStations    = new JButton("Report damage");
    private JButton btnLogout             = new JButton("      LogOut      ");
    JPanel panel                          = new JPanel();
    private ManagerTollStation managerTollStation;
    public ManagerTollStationFrame(ManagerTollStation managerTollStation) {
        this.managerTollStation = managerTollStation;
        setTitle("Welcome " + managerTollStation.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,300);
        setResizable(false);

        btncreateUser.setPreferredSize(new Dimension(40, 20));
        btnAllTollStations.setPreferredSize(new Dimension(60, 20));
        btnLogout.setPreferredSize(new Dimension(60, 20));

        panel.setLayout(new MigLayout("wrap 1"));

        panel.add(btncreateUser);
        panel.add(btnAllTollStations);
        panel.add(btnLogout);

        add(panel,BorderLayout.CENTER);
        pack();

        btncreateUser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CreateUserFrame createUserFrame = new CreateUserFrame();
                createUserFrame.setVisible(true);
            }
        });

        btnAllTollStations.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ViewTollStations viewTollStations = new ViewTollStations();
                viewTollStations.setVisible(true);
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
