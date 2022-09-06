package ViewMainFrames;

import Model.ManagerTollStation;
import Model.TagOwner;
import View.CreateUserFrame;
import View.LoginFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TagOwnerFrame extends JFrame{
    private JButton btnBuyTag         = new JButton("  Buy Tag  ");
    private JButton btnEntry    = new JButton("Entry road");
    private JButton btnExit    = new JButton(" Exit road ");
    private JButton btnLogout             = new JButton("  LogOut  ");
    JPanel panel                          = new JPanel();
    private TagOwner tagOwner;
    public TagOwnerFrame(TagOwner tagOwner) {
        this.tagOwner = tagOwner;
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,300);
        setResizable(false);

        btnBuyTag.setPreferredSize(new Dimension(40, 20));
        btnEntry.setPreferredSize(new Dimension(60, 20));
        btnExit.setPreferredSize(new Dimension(60, 20));
        btnLogout.setPreferredSize(new Dimension(60, 20));

        panel.setLayout(new MigLayout("wrap 1"));

        panel.add(btnBuyTag);
        panel.add(btnEntry);
        panel.add(btnExit);
        panel.add(btnLogout);

        add(panel,BorderLayout.CENTER);
        pack();

        btnBuyTag.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                CreateUserFrame createUserFrame = new CreateUserFrame();
                createUserFrame.setVisible(true);
            }
        });

        btnEntry.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }

        });

        btnExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

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
