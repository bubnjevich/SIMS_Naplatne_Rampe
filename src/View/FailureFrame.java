package View;

import Model.BilingOfficer;
import Model.Failure;
import Model.TollBooth;
import Model.User;
import Repository.FailuresRepository;
import Repository.TollBothRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class FailureFrame extends JFrame{

        /**
         *
         */
        private static final long serialVersionUID = -17676587391118465L;
        private JTextArea failureDescription = new JTextArea();
        private JLabel lblId = new JLabel("Id");
        private JTextField txtId=new JTextField(20);
        private JButton btnConfirm           = new JButton("Confirm");
        private JButton btnCancel            = new JButton("Cancel");
        JPanel panel                         = new JPanel();
        JPanel panel1                       = new JPanel();
        private FailuresRepository failuresRepository;
        private TollBothRepository tollBothRepository;
        private BilingOfficer bilingOfficer;
        public FailureFrame(BilingOfficer bilingOfficer) {
            this.failuresRepository = new FailuresRepository();
            this.tollBothRepository = new TollBothRepository();
            this.bilingOfficer = bilingOfficer;
            setTitle("Report failure!");
            setLayout(new BorderLayout());
            setSize(400, 400);
            setResizable(false);
            setVisible(true);

            panel1.setLayout(new MigLayout("wrap 2"));
            panel1.add(lblId);
            panel1.add(txtId);
            add(panel1,BorderLayout.NORTH);

            failureDescription.setLayout(new FlowLayout(FlowLayout.RIGHT));
            failureDescription.setLineWrap(true);
            failureDescription.setWrapStyleWord(true);

            add(failureDescription, BorderLayout.CENTER);
            panel.add(btnConfirm);
            panel.add(btnCancel);
            add(panel,BorderLayout.SOUTH);


            btnConfirm.addActionListener (new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String id = Math.random()+"";
                    TollBooth tollBooth = tollBothRepository.findTollBothById(txtId.getText());
                    Failure failure = new Failure(id,failureDescription.getText(), LocalDate.now(),tollBooth,bilingOfficer);
                    failuresRepository.getFailures().add(failure);
                    failuresRepository.saveFailures();
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


