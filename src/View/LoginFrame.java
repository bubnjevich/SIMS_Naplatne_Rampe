package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.Admin;
import Model.BilingOfficer;
import Model.ManagerTollStation;
import Model.User;
import Repository.UserRepository;
import Service.UserService;
import ViewMainFrames.AdminFrame;
import ViewMainFrames.BilingOfficerFrame;
import ViewMainFrames.ManagerTollStationFrame;
import net.miginfocom.swing.MigLayout;



public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -17676587391118465L;
	private JLabel lbluser=new JLabel("username");
	private JTextField txtuser=new JTextField(20);
	private JLabel lblpass=new JLabel("password");
	private JTextField txtlblpass=new JPasswordField(20);
	private JButton btnConfirm= new JButton("Confirm");
	private JButton btnCancel= new JButton("Cancel");
	private UserService userService;
	
	public LoginFrame() {
		this.userService = new UserService();
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		initGui();
		pack();

	}
	public void initGui() {
		MigLayout mig= new MigLayout("wrap 2");
		setLayout(mig); 
		add(lbluser);
		add(txtuser);
		add(lblpass);
		add(txtlblpass);
		add(new JLabel());
		add(btnConfirm,"split 2");
		add(btnCancel);

		btnConfirm.addActionListener (new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				User user = userService.findUserByEmailAndPass(txtuser.getText(),txtlblpass.getText());
				if (user!=null) {
					setVisible(false);
					if (user instanceof Admin) {
						AdminFrame adminFrame = new AdminFrame((Admin) user);
						adminFrame.setVisible(true);

					} else if (user instanceof BilingOfficer) {
						BilingOfficerFrame bilingOfficerFrame = new BilingOfficerFrame((BilingOfficer) user);
						bilingOfficerFrame.setVisible(true);

					} else if (user instanceof ManagerTollStation) {
						ManagerTollStationFrame managerTollStationFrame = new ManagerTollStationFrame((ManagerTollStation) user);
						managerTollStationFrame.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(null, "User doesnt exist","Wrong data",JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btnCancel.addActionListener (new ActionListener() {

			public void actionPerformed(ActionEvent e) {System.exit(0);}
		});
	}
}
						
							
						
			
				
				
		
