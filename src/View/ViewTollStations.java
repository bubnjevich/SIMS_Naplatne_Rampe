package View;

import Location.TollStation;
import Repository.TollStationRepository;
import TableModels.StationModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewTollStations extends JFrame {
    protected JTable table;
    protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
    protected JToolBar mainToolbar = new JToolBar();
    protected JTextField tfSearch = new JTextField(20);
    protected JMenuBar jMenuBar;
    protected JMenuItem jMenuItem;
    protected JMenu jMenu;


    public ViewTollStations() {
        TollStationRepository tollStationRepository = new TollStationRepository();
        JPanel panel = new JPanel();
        this.setTitle("Toll Stations");
        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        table = new JTable(new StationModel(tollStationRepository.getTollStations()));
        table.setPreferredScrollableViewportSize(new Dimension(500, 700));
        table.getTableHeader().setReorderingAllowed(false);
        tableSorter.setModel((AbstractTableModel) table.getModel());

        this.jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Options");
        this.jMenu = jMenu;
        JMenuItem jMenuItem = new JMenuItem("Add Toll Station");
        JMenuItem jMenuItem1 = new JMenuItem("Edit Toll Station");
        JMenuItem jMenuItem2 = new JMenuItem("Remove Toll Station");

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        this.jMenuItem = jMenuItem;
        jMenuBar.add(jMenu);
        mainToolbar.setBackground(Color.orange);


        mainToolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainToolbar.setSize(500, 40);
        mainToolbar.add(jMenuBar);
        mainToolbar.setFloatable(false);
        add(mainToolbar, BorderLayout.NORTH);


        table.setRowSorter(tableSorter);

        table.getColumnModel().getColumn(0).setMinWidth(90);
        table.getColumnModel().getColumn(1).setMinWidth(90);

        JScrollPane sc = new JScrollPane(table);
        add(sc);


        JPanel pSearch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pSearch.setBackground(Color.orange);
        pSearch.add(new JLabel("Search:"));
        pSearch.add(tfSearch);
        add(pSearch, BorderLayout.SOUTH);

        this.setVisible(true);

        tfSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (tfSearch.getText().trim().length() == 0) {
                    tableSorter.setRowFilter(null);
                } else {
                    tableSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tfSearch.getText().trim()));
                }
            }
        });


        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStationFrame createStationFrame = new CreateStationFrame();

            }
        });

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = table.getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(null, "You must select a row from the table.",
                            "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    String stationName = table.getValueAt(red, 0).toString();
                    TollStation tollStation = tollStationRepository.findTollStationByName(stationName);
                    EditStationFrame editStationFrame = new EditStationFrame(tollStation, tollStationRepository);
                }
            }
        });

        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = table.getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(null, "You must select a row from the table..",
                            "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    String stationName = table.getValueAt(red, 0).toString();
                    TollStation tollStation = tollStationRepository.findTollStationByName(stationName);
                    if (tollStation != null) {
                        int izbor = JOptionPane.showConfirmDialog(null, "Are you sure to delete ?",
                                tollStation.getName() + " - Delete confirm", JOptionPane.YES_NO_OPTION);
                        if (izbor == JOptionPane.YES_OPTION) {
                            tollStationRepository.RemoveTollStation(tollStation);
                            setVisible(false);

                        }

                    }
                }
            }
        });




    }
}