package View;

import Model.Failure;
import Repository.FailuresRepository;
import Repository.TollBothRepository;
import TableModels.FailuresModel;
import TableModels.TollBoothModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ViewFailures extends JFrame {
    protected JTable table;
    protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
    protected JToolBar mainToolbar = new JToolBar();
    protected JTextField tfSearch = new JTextField(20);
    protected JMenuBar jMenuBar;
    protected JMenuItem jMenuItem;
    protected JMenu jMenu;

    public ViewFailures() {
        FailuresRepository failuresRepository = new FailuresRepository();
        this.setTitle("Failures");
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        table = new JTable(new FailuresModel(failuresRepository.getFailures()));
        table.setPreferredScrollableViewportSize(new Dimension(500, 700));
        table.getTableHeader().setReorderingAllowed(false);
        tableSorter.setModel((AbstractTableModel) table.getModel());

        this.jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Options");
        this.jMenu = jMenu;
        JMenuItem jMenuItem = new JMenuItem("Repair");

        jMenu.add(jMenuItem);

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
                int red = table.getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(null, "You must select a row from the table.",
                            "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    String failureId = table.getValueAt(red, 0).toString();
                    Failure failure = failuresRepository.findFailureById(failureId);
                    failure.setDateOfRepair(LocalDate.now());
                    JOptionPane.showMessageDialog(null, "Repaired.",
                            "INFO", JOptionPane.PLAIN_MESSAGE);
                    failuresRepository.saveFailures();
                }
            }
        });
    }
}
