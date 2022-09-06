package View;

import Model.Report;
import Repository.ReportRepository;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ReportFrame extends JFrame {
	private static final long serialVersionUID = -1353912940009038249L;
	private JButton btnAdd=new JButton("Add"); 
	private JButton btnDelete=new JButton("Delete"); 
	private JButton btnEdit=new JButton("Edit");
	 
	private DefaultTableModel table;
	private JTable dataTable;
	private ReportRepository reportRepository;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public ReportFrame() {
			this.reportRepository = new ReportRepository();
			setTitle("Reports");
			setSize(700, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			initGui();
		}
	private void initGui () {

		String[] header = new String[]{"Amount", "Entry", "Exit", "Registration", "DateTime"};
		Object[][] content = new Object[reportRepository.getReports().size()][header.length];
		for (int i = 0; i < reportRepository.getReports().size(); i++) {
			Report report = reportRepository.getReports().get(i);
			content[i][0] = report.getAmount();
			content[i][1] = report.getEntry().getTollStation().getName();
			content[i][2] = report.getExit().getTollStation().getName();
			content[i][3] = report.getRegistrationPlate();
			content[i][4] = report.getLocalDateTime().format(formatter);

		}
		DefaultTableModel table = new DefaultTableModel(content, header);
		JTable datatable = new JTable(table);

		datatable.setRowSelectionAllowed(true);
		datatable.setColumnSelectionAllowed(false);
		datatable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		datatable.setDefaultEditor(Object.class, null);
		datatable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollpane = new JScrollPane(datatable);
		add(scrollpane, BorderLayout.CENTER);




	}
}
