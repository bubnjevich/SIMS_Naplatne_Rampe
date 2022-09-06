package TableModels;

import Location.TollStation;
import Model.TollBooth;
import Repository.TollBothRepository;
import Repository.TollStationRepository;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StationModel extends AbstractTableModel {

    private final String[] columnNames = {"NAME", "PLACE"};
    private final ArrayList<TollStation> tollStations;
    public StationModel(ArrayList<TollStation> tollStations) {
        this.tollStations = tollStations;
    }


    @Override
    public int getRowCount() {
        return tollStations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TollStation tollStation = tollStations.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> tollStation.getName();
            case 1 -> tollStation.getPlace().getPlaceName();
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
