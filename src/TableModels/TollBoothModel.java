package TableModels;

import Model.TollBooth;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TollBoothModel extends AbstractTableModel {
    private final String[] columnNames = {"TOLL BOOTH ID", "STATION", "IS WORKING"};
    private final ArrayList<TollBooth> tollBooths;

    public TollBoothModel(ArrayList<TollBooth> tollBooths) {
        this.tollBooths = tollBooths;
    }

    @Override
    public int getRowCount() {
        return tollBooths.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TollBooth tollBooth = tollBooths.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tollBooth.getId();
            case 1:
                return tollBooth.getTollStation().getName();
            case 2: {
                if (tollBooth.getIsWorking() == 0)
                    return "Working";
                else return "Not working";
            }
            default:
                return null;
        }
    };

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.getValueAt(0, columnIndex).getClass();
    }
}
