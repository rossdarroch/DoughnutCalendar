//import javax.swing.JPanel;

import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.table.*;
import javax.swing.JTable;

public class MonthlyView extends AndroidWindow {

	@Override
	public void setup(Container panel) {
		TableModel dataModel = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;
			private String[] week = {"", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
			public int getColumnCount() {
				return 8;
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
		JTable table = new JTable(dataModel);
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane);
	}
}
