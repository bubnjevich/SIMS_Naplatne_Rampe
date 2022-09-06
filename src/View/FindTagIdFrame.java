package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class FindTagIdFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -17676587391118465L;
    private JLabel lblId = new JLabel("Id");
    private JTextField txtId=new JTextField(20);
    private JButton btnFind= new JButton("Find");
    private JButton btnCancel= new JButton("Cancel");

    public FindTagIdFrame() {
        setTitle("Find tag by id");
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

                txtId.getText();
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