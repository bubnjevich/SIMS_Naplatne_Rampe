package TableModels;

import Model.Failure;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class FailuresModel extends AbstractTableModel {

    private final ArrayList<Failure> failures;
    private final String[] columnNames = {"FAILURE ID", "DESCRIPTION", "DEFECT DATE", "TOLL BOOTH", "USER", "REPAIRED"};

    public FailuresModel(ArrayList<Failure> failures) {
        this.failures = failures;
    }


    @Override
    public int getRowCount() {
        return failures.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Failure failure = failures.get(rowIndex);
         switch (columnIndex) {
             case 0:
                 return failure.getId();
             case 1:
                 return failure.getDescription();
             case 2:
                 return failure.getDateOfDefect();
             case 3:
                 return failure.getTollBooth().getId();
             case 4:
                 return failure.getUser().getName() + " " + failure.getUser().getLastName();
             case 5: {
                 if (failure.getDateOfRepair().equals(LocalDate.of(1111, 11, 11)))
                     return "Not repaired";
                 else
                     return "Repaired";
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
