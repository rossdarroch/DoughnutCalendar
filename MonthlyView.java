

import java.awt.Component;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import javax.swing.JTable;

import calendar_ex.CalendarDate;

public class MonthlyView extends AndroidWindow {
	
	private String vmonth;
	private int fweek, fday, fmonth;
	private Context c;
	private CalendarDate vdate;
	private int selr, selc;


	
	public MonthlyView() {
		super();
		c = Context.getContext();
		vdate = c.getViewDate();
		vmonth = CalendarDate.getMonth(vdate.month);
		GregorianCalendar cal = new GregorianCalendar(vdate.year, vdate.month, 1);
		fweek = cal.get(Calendar.WEEK_OF_YEAR);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		fday = cal.get(Calendar.DAY_OF_MONTH);
		fmonth = cal.get(Calendar.MONTH);
	}
	
	static class CellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = -310688878701416938L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			renderedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return renderedLabel;
		}
	}
	
	@Override
	public void setup(JPanel panel) {
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
				GregorianCalendar cal = new GregorianCalendar(vdate.year, vdate.month, 1);
				cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				cal.add(Calendar.DAY_OF_MONTH, 7*row+col-1);
				return cal.get(Calendar.DAY_OF_MONTH);
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
		/*if (cal.get(Calendar.DAY_OF_MONTH) == vdate.day && cal.get(Calendar.MONTH) == vdate.month) {
			selr = row;
			selc = col;
		}
		monthTable.changeSelection(selr, selc, false, false);
		*/
		JScrollPane scrollpane = new JScrollPane(monthTable);
		//scrollpane.setSize(panel.getSize());
		
		JLabel monthLabel = new JLabel(vmonth);

		JTable rowTable = new RowNumberTable(monthTable, fweek);
		//rowTable.setPreferredSize(new Dimension(panel.getWidth()/8, panel.getHeight()));
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,	rowTable.getTableHeader());
		

		
		//panel.add(monthLabel);
		panel.add(scrollpane);
	}
}
