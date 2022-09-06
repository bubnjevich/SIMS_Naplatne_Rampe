package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Archives.Tag;
import Enumerations.Gender;
import net.miginfocom.swing.MigLayout;

public class AddCreditTagFrame extends JFrame {
	private static final long serialVersionUID = -6865384537646727961L;
	private Tag tag;
	private JLabel lblid=new JLabel("Id: " + tag.getId());

	private JLabel lblName=new JLabel("Id: " + tag.getTagOwner().getName());

	private JLabel lblAmount=new JLabel("password");
	private JTextField txtAmount = new JTextField(20);
	private JButton btnConfirm           = new JButton("Confirm");
	private JButton btnCancel            = new JButton("Cancel");





	public AddCreditTagFrame(Tag tag) {
		this.tag = tag;
		
		setTitle("Add Credit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		setResizable(false);
		pack();

		btnConfirm.addActionListener (new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});

		btnCancel.addActionListener (new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
	}

	private void initGUI() {
		MigLayout mig= new MigLayout("wrap 2");
		setLayout(mig); 
		add(lblid);
		add(new JLabel());
		add(lblName);
		add(new JLabel());
		add(lblAmount);
		add(txtAmount);
		add(new JLabel());
		add(btnConfirm,"split 2");
		add(btnCancel);
		}


			
	
}
