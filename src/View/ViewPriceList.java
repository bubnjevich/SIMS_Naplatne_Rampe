package View;

import Repository.FailuresRepository;
import Repository.PriceListRepository;
import TableModels.FailuresModel;
import TableModels.PriceListModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ViewPriceList extends JFrame {
    protected JTable table;
    protected TableRowSorter<AbstractTableModel> tableSorter = new TableRowSorter<AbstractTableModel>();
    protected JToolBar mainToolbar = new JToolBar();
    protected JTextField tfSearch = new JTextField(20);
    protected JMenuBar jMenuBar;
    protected JMenuItem jMenuItem;
    protected JMenu jMenu;

    public ViewPriceList() {
        PriceListRepository priceListRepository = new PriceListRepository();
        this.setTitle("Price List");
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        table = new JTable(new PriceListModel(priceListRepository.getPriceLists()));
        table.setPreferredScrollableViewportSize(new Dimension(500, 700));
        table.getTableHeader().setReorderingAllowed(false);
        tableSorter.setModel((AbstractTableModel) table.getModel());

        this.jMenuBar = new JMenuBar();
        mainToolbar.setBackground(Color.orange);


        mainToolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainToolbar.setSize(500, 40);
        mainToolbar.add(jMenuBar);
        mainToolbar.setFloatable(false);
        add(mainToolbar, BorderLayout.NORTH);

        table.setRowSorter(tableSorter);

        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(90);
        table.getColumnModel().getColumn(2).setMaxWidth(90);
        table.getColumnModel().getColumn(3).setMaxWidth(90);

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
    }
}