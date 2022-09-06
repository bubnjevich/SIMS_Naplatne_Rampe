package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

import Enumerations.Gender;
import Enumerations.Role;
import Location.Address;
import Location.Place;
import Model.*;
import Service.PlaceService;
import Service.UserService;
import net.miginfocom.swing.MigLayout;

public class CreateUserFrame extends JFrame {
	private static final long serialVersionUID = -6865384537646727961L;

	private JLabel lblid               = new JLabel("Id");
	private JTextField txtid	       = new JTextField(20);
	private JLabel lblBirth		       = new JLabel("Birthday");
	private JTextField txtBirth		   = new JTextField(20);
	private JLabel lblName		       = new JLabel("Name");
	private JTextField txtName	       = new JTextField(20);
	private JLabel lblLastName	       = new JLabel("LastName");
	private JTextField txtLastName     = new JTextField(20);
	private JLabel lblUsername         = new JLabel("Username");
	private JTextField txtUsername     = new JTextField(20);
	private JLabel lblPassword 		   = new JLabel("Password");
	private JTextField txtlblPassword  = new JPasswordField(20);
	private JLabel lblGender 		   = new JLabel("Gender");
	private Gender[] genders 		   = {Gender.FEMALE,Gender.MALE};
	private JComboBox<Gender> cbGender = new JComboBox<Gender>(genders);
	private JLabel lblStreet 		   = new JLabel("Street");
	private JTextField txtStreet 	   = new JTextField(20);

	private JLabel lblHouseNum 		   = new JLabel("House number");
	private JTextField txtHouseNum 	   = new JTextField(20);

	private JLabel lblZipcode 		   = new JLabel("ZipCode");
	private JTextField txtZipcode 	   = new JTextField(20);
	private JLabel lblPhone 		   = new JLabel("Phone");
	private JTextField txtPhone 	   = new JTextField(20);
	private JLabel lblRoles 		   = new JLabel("Role");
	private Role[] roles 		   = {Role.ADMIN,Role.TAGSELLER,Role.BILINGOFFICER,Role.MANAGERTOLLSTATION,Role.UPPERMANAGER};
	private JComboBox<Role> cbRoles = new JComboBox<Role>(roles);
	private JButton btnConfirm 		   = new JButton("Confirm");
	private JButton btnCancel 		   = new JButton("Cancel");
	private UserService userService;
	private PlaceService placeService;

	public CreateUserFrame(){
		this.userService  = new UserService();
		this.placeService = new PlaceService();
		setTitle("Create user");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		setResizable(false);
		pack();
	}
	
	private boolean validation() {
		 boolean valid =true;
		 LocalDate dateCheck=null;
		 String message=("Please correct the answers");
		 if(txtName.getText().trim().equals("")) {
			message +=" Enter name\n" ;
			valid=false;
		 }
		 if(txtLastName.getText().trim().equals("")) {
			message +=" Enter LastName\n" ;
			valid=false;
		 }
		 if(txtBirth.getText().trim().equals("")) {
			message +=" Enter birthday\n" ;
			valid=false;
		 }
		 if(txtStreet.getText().trim().equals("")) {
				message +=" Enter address\n" ;
				valid=false;
		 }
		 if(txtUsername.getText().trim().equals("")) {
			message +=" Enter username\n" ;
			valid=false;
		 }
		 if(txtid.getText().trim().equals("")) {
			message +=" Enter id\n" ;
			valid=false;
		 }
		 if(txtlblPassword.getText().trim().equals("")) {
				message +=" Enter passowrd\n" ;
				valid=false;
		 }
		 try {
			 dateCheck=LocalDate.parse(txtBirth.getText().trim(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception e) {
			message +=" Wrong date format(yyyy-MM-dd)\n" ;
			valid=false;
		}
		if(valid == false) {
			 JOptionPane.showMessageDialog(null, message,"Incorrect data",JOptionPane.WARNING_MESSAGE);
		}
		return valid;
	}
	
	private void initGUI() {

		MigLayout mig= new MigLayout("wrap 2");


		setLayout(mig); 
		add(lblid);
		add(txtid);
		
		add(lblName);
		add(txtName);
		
		add(lblLastName);
		add(txtLastName);
		
		add(lblGender);
		add(cbGender);
		
		add(lblBirth);
		add(txtBirth);
		
		add(lblPhone);
		add(txtPhone);
		
		add(lblStreet);
		add(txtStreet);

		add(lblHouseNum);
		add(txtHouseNum);

		add(lblZipcode);
		add(txtZipcode);

		add(lblRoles);
		add(cbRoles);

		add(lblUsername);
		add(txtUsername);
		
		add(lblPassword);
		add(txtlblPassword);
		
		add(new JLabel());
		add(btnConfirm,"split 2");
		add(btnCancel);
		
		
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(validation()) {
					int id=Integer.parseInt(txtid.getText().trim());
					String name		= txtName.getText().trim();
					String lastName = txtLastName.getText().trim();
					String street	= txtStreet.getText().trim();
					String houseNum	= txtHouseNum.getText().trim();
					String zipCode	= txtZipcode.getText().trim();
					String phone	= txtPhone.getText().trim();
					LocalDate date	= LocalDate.parse(txtBirth.getText().trim());
					Gender Gender	= (Gender)cbGender.getSelectedItem();
					String username	= txtUsername.getText().trim();
					String password	= txtlblPassword.getText().trim();
					Role role		= (Role)cbRoles.getSelectedItem();
					Place place     = placeService.findPlaceByZipcode(zipCode);
					Address address = new Address(street,houseNum,place);
					if(role == Role.TAGSELLER)
						userService.createUser(new TagSeller(name,lastName,username,password,Gender,phone,address,role));
					if(role == Role.ADMIN)
						userService.createUser(new Admin(name,lastName,username,password,Gender,phone,address,role));
					if(role == Role.UPPERMANAGER)
						userService.createUser(new UpperManager(name,lastName,username,password,Gender,phone,address,role));
					if(role == Role.BILINGOFFICER)
						userService.createUser(new BilingOfficer(name,lastName,username,password,Gender,phone,address,role));
					if(role == Role.MANAGERTOLLSTATION)
						userService.createUser(new ManagerTollStation(name,lastName,username,password,Gender,phone,address,role));



				CreateUserFrame.this.dispose();
				CreateUserFrame.this.setVisible(false);
				}
			}

		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}
}