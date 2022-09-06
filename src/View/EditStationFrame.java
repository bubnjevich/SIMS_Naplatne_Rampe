package View;

import Location.Place;
import Location.TollStation;
import Repository.PlaceRepository;
import Repository.TollStationRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EditStationFrame extends JFrame {
    private final TollStation tollStation;
    private final JLabel lblName      = new JLabel("Name");
    private final JTextField txtName  = new JTextField(20);
    private final JLabel lblZipCode     = new JLabel("Place");
    private final JTextField txtZipCode = new JTextField(20);
    private final JButton btnConfirm  = new JButton("Confirm");
    private final JButton btnCancel   = new JButton("Cancel");
    private final PlaceRepository placeRepository;
    private final TollStationRepository tollStationRepository;

    public EditStationFrame(TollStation tollStation, TollStationRepository tollStationRepository) {
        this.tollStation = tollStation;
        placeRepository = new PlaceRepository();
        this.tollStationRepository = tollStationRepository;
        setTitle("Edit Toll Station");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        setResizable(false);
        pack();
    }

    private boolean validation() {
        boolean valid =true;
        String message=("Please correct the answers");
        if(txtName.getText().trim().equals("")) {
            message +=" Enter name\n" ;
            valid=false;
        }
        if(txtZipCode.getText().trim().equals("")) {
            message +=" Enter zip code\n" ;
            valid=false;
        }
        if (placeRepository.findPlaceByZipCode(txtZipCode.getText()) == null ) {
            message +="Place with given zip code is not registered\n" ;
            valid=false;
        }
        if(!valid) {
            JOptionPane.showMessageDialog(null, message,"Incorrect data",JOptionPane.WARNING_MESSAGE);
        }
        return valid;
    }

    public void initGUI() {

        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblName);
        txtName.setText(tollStation.getName());
        add(txtName);
        add(lblZipCode);
        txtZipCode.setText(tollStation.getPlace().getZipCode());
        add(txtZipCode);

        add(new JLabel());
        add(btnConfirm,"split 2");
        add(btnCancel);

        setVisible(true);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validation())
                    return;
                String tollStationName = txtName.getText().trim();
                Place place = placeRepository.findPlaceByZipCode(txtZipCode.getText());
                tollStation.setName(tollStationName);
                tollStation.setPlace(place);
                tollStationRepository.saveTollStations();
                setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
