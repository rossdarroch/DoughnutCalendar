//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.JFrame;


public class MonthlyView {

	public MonthlyView(JFrame parent) {
		TableModel dataModel = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;

			public int getColumnCount() {
				return 10;
			}

			public int getRowCount() {
				return 10;
			}

			public Object getValueAt(int row, int col) {
				return new Integer(row * col);
			}
		};
		JTable table = new JTable(dataModel);
		JScrollPane scrollpane = new JScrollPane(table);
		parent.add(scrollpane);
	}
}
