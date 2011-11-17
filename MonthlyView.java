//import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import javax.swing.JTable;

public class MonthlyView extends AndroidWindow {

	static class CellRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			renderedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return renderedLabel;
		}
	}
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
		monthTable.setDefaultRenderer(Object.class, new CellRenderer());
		monthTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		monthTable.setRowSelectionAllowed(false);
		monthTable.setCellSelectionEnabled(true);
		monthTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//monthTable.setPreferredScrollableViewportSize(new Dimension(400, 500));
		//
		monthTable.setRowHeight(60);
		monthTable.setPreferredScrollableViewportSize(new Dimension(panel.getWidth()-100, panel.getHeight()));

		//monthTable.setCol
		monthTable.doLayout();
		
		JScrollPane scrollpane = new JScrollPane(monthTable);
		//scrollpane.setSize(panel.getSize());
		
		JTable rowTable = new RowNumberTable(monthTable, 45);
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,	rowTable.getTableHeader());
		panel.add(scrollpane);
	}
	
}
