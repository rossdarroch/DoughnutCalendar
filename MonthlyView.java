//import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import javax.swing.JTable;

public class MonthlyView extends AndroidWindow {

	@Override
	public void setup(Container panel) {
		TableModel dataModel = new AbstractTableModel() {
			private static final long serialVersionUID = 89037589235789234L;
			private String[] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				return 6;
			}

			public String getColumnName(int col) {
				return week[col];
			}
			
			public Object getValueAt(int row, int col) {
				return new Integer(row * col);
			}
		};
		JTable monthTable = new JTable(dataModel);
		monthTable.setRowSelectionAllowed(false);
		monthTable.setCellSelectionEnabled(true);
		monthTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//monthTable.setPreferredScrollableViewportSize(new Dimension(480, 800));
		monthTable.doLayout();
		
		JScrollPane scrollpane = new JScrollPane(monthTable);
		
		
		
		JTable rowTable = new RowNumberTable(monthTable, 45);
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
		    rowTable.getTableHeader());
		
		panel.add(scrollpane);
	}
}
