package View;

import Location.TollStation;
import Model.TollBooth;
import Repository.TollBothRepository;
import Repository.TollStationRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CreateTollBoothFrame extends JFrame {
    private final JLabel lblName      = new JLabel("ID");
    private final JLabel lblStations      = new JLabel("Station");
    private final JLabel lblWorking      = new JLabel("Is working");
    private final JTextField txtName  = new JTextField(7);
    private JComboBox<String> stations;
    private final JRadioButton yesButton = new JRadioButton("Yes");
    private final JRadioButton noButton = new JRadioButton("No");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final TollStationRepository tollStationRepository;
    private final TollBothRepository tollBothRepository;

    private final JButton btnConfirm  = new JButton("Confirm");
    private final JButton btnCancel   = new JButton("Cancel");

    public CreateTollBoothFrame() {
        setTitle("Create Toll Station");
        tollStationRepository = new TollStationRepository();
        tollBothRepository = new TollBothRepository();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        loadStations();
        initGUI();
        setResizable(false);
        pack();
    }

    private void loadStations() {
        ArrayList<String> items = new ArrayList<String>();
        for (TollStation tollStation : tollStationRepository.getTollStations()) {
            items.add(tollStation.getName());
        }
        String[] strItems = new String[items.size()];
        items.toArray(strItems);
        stations = new JComboBox<>(strItems);
        stations.setEditable(true);
        stations.setSelectedItem("Station");
    }


    public void initGUI() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblName);
        add(txtName);
        add(lblStations);
        add(stations);
        add(lblWorking);
        buttonGroup.add(yesButton);
        buttonGroup.add(noButton);
        JPanel panel = new JPanel();
        panel.add(yesButton);
        panel.add(noButton);
        add(panel, "span 3");
        add(new JLabel());

        add(btnConfirm,"split 2");
        add(btnCancel);
        setVisible(true);


        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtName.getText().trim();

                if (id.equals("")) {
                    JOptionPane.showMessageDialog(null, "Empty input!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (tollBothRepository.findTollBothById(id) != null) {
                    JOptionPane.showMessageDialog(null, "ID already exists", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String varName = (String)stations.getSelectedItem();
                if (Objects.equals(varName, "Stations")) {
                    JOptionPane.showMessageDialog(null, "Must select station", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                TollStation station = tollStationRepository.findTollStationByName(varName);
                int working;
                if (yesButton.isSelected()) {
                    working = 0;
                } else {
                    working = 1;
                }

                TollBooth tollBooth = new TollBooth(id, station, working);
                tollBothRepository.AddToolBooth(tollBooth);
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
