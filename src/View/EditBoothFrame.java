package View;

import Location.TollStation;
import Model.TollBooth;
import Repository.TollBothRepository;
import Repository.TollStationRepository;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditBoothFrame extends JFrame {
    private final JLabel lblName      = new JLabel("ID");
    private final JLabel lblStations      = new JLabel("Station");
    private final JLabel lblWorking      = new JLabel("Is working");
    private final JLabel lblId;
    private JComboBox<String> stations;
    private final JRadioButton yesButton = new JRadioButton("Yes");
    private final JRadioButton noButton = new JRadioButton("No");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final TollBooth tollBooth;
    private final TollStationRepository tollStationRepository;
    private final TollBothRepository tollBothRepository;

    private final JButton btnConfirm  = new JButton("Confirm");
    private final JButton btnCancel   = new JButton("Cancel");

    public EditBoothFrame(TollBooth tollBooth, TollBothRepository tollBothRepository) {
        this.tollBooth = tollBooth;
        this.tollBothRepository = tollBothRepository;
        tollStationRepository = new TollStationRepository();
        this.lblId = new JLabel(tollBooth.getId());
        setTitle("Edit Toll Booth");
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
        stations.setSelectedItem(tollBooth.getTollStation().getName());
    }

    public void initGUI() {
        MigLayout mig= new MigLayout("wrap 2");
        setLayout(mig);
        add(lblName);
        add(lblId);
        add(lblStations);
        add(stations);
        add(lblWorking);
        buttonGroup.add(yesButton);
        buttonGroup.add(noButton);
        JPanel panel = new JPanel();
        panel.add(yesButton);
        panel.add(noButton);
        if (tollBooth.getIsWorking() == 0) {
            yesButton.setSelected(true);
            noButton.setSelected(false);
        } else {
            yesButton.setSelected(false);
            noButton.setSelected(true);
        }

        add(panel, "span 3");
        add(new JLabel());

        add(btnConfirm,"split 2");
        add(btnCancel);
        setVisible(true);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String varName = (String)stations.getSelectedItem();
                TollStation tollStation = tollStationRepository.findTollStationByName(varName);
                int isWorking;
                if (yesButton.isSelected())
                    isWorking = 0;
                else
                    isWorking = 1;
                tollBooth.setTollStation(tollStation);
                tollBooth.setIsWorking(isWorking);
                tollBothRepository.saveTollBooths();
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
