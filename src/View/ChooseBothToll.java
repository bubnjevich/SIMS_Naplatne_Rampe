package View;

import Model.TollBooth;
import Model.User;
import Repository.TollBothRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseBothToll extends JFrame{
    private static final long serialVersionUID = -17676587391118465L;
    private JLabel lblId = new JLabel("Id");
    private JTextField txtId=new JTextField(20);
    private JButton btnFind= new JButton("Choose");
    private JButton btnCancel= new JButton("Cancel");
    private TollBothRepository tollBothRepository;
    private User user;

    public ChooseBothToll(User user) {
        this.tollBothRepository = new TollBothRepository();
        this.user=user;
        setTitle("Find tollBoth by id");
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
                TollBooth tollBooth = tollBothRepository.findTollBothById(txtId.getText());
                PassByIdFrame paymentFrame = new PassByIdFrame(tollBooth.getTollStation());
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
