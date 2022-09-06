package ViewMainFrames;

import Archives.Tag;
import Model.Admin;
import View.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {
    private static final long serialVersionUID = -6865384537646727961L;
    private JButton btnPriceList = new JButton("Price List");
    private JButton btnTollStations = new JButton("Toll Stations");
    private JButton btnTollBooths = new JButton("Toll Booths");
    private JButton btnFailures = new JButton("Failures");
    private JButton btnReports   = new JButton("  Reports ");
    private JButton btnLogout    = new JButton("  LogOut  ");

    JPanel panel = new JPanel();
    private Admin admin;


    public AdminFrame(Admin admin) {
        this.admin = admin;
        setTitle("Welcome " + admin.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,150);
        setResizable(false);

        btnTollStations.setPreferredSize(new Dimension(120, 20));
        btnFailures.setPreferredSize(new Dimension(120, 20));
        btnTollBooths.setPreferredSize(new Dimension(120, 20));
        btnPriceList.setPreferredSize(new Dimension(120, 20));
        btnReports.setPreferredSize(new Dimension(120, 20));
        btnLogout.setPreferredSize(new Dimension(120, 20));

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(btnTollStations);
        panel.add(btnTollBooths);
        panel.add(btnPriceList);
        panel.add(btnFailures);
        panel.add(btnReports);
        panel.add(btnLogout);

        add(panel,BorderLayout.CENTER);


        btnTollStations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTollStations viewTollStations = new ViewTollStations();
            }
        });

        btnTollBooths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTollBooths viewTollBooths = new ViewTollBooths();
            }
        });

        btnPriceList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewPriceList viewPriceList = new ViewPriceList();
            }
        });

        btnFailures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewFailures viewFailures = new ViewFailures();
            }
        });

        btnReports.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ReportFrame reportFrame = new ReportFrame();
                reportFrame.setVisible(true);
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
