package TableModels;

import Prices.PriceListItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PriceListModel extends AbstractTableModel {
    private final String[] columnNames = {"ROAD SECTION", "VEHICLE", "RSD", "EUR"};
    private final ArrayList<PriceListItem> items;

    public PriceListModel(ArrayList<PriceListItem> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PriceListItem item = items.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> item.getRoadSection().getStartTollStation().getName() + "-" + item.getRoadSection().getEndTollStation().getName();
            case 1 -> item.getTypeOfVehicle();
            case 2 -> item.getrsd();
            case 3 -> item.geteur();
            default -> null;
        };

    }


    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.getValueAt(0, columnIndex).getClass();
    }
}
