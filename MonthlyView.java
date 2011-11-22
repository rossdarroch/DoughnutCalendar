

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
	private CalendarDate vdate, cdate;
	private int selr, selc;
	private int[] days;
	
	//BIG FAT WARNING: in Java's Calendar months are ZERO-BASED!!!
	
	public MonthlyView() {
		super();
		c = Context.getContext();
		vdate = c.getViewDate();
		cdate = c.getCurrentDate();
		vmonth = CalendarDate.getMonth(vdate.month);
		GregorianCalendar cal = new GregorianCalendar(vdate.year, vdate.month-1, 1);
		fweek = cal.get(Calendar.WEEK_OF_YEAR);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		fday = cal.get(Calendar.DAY_OF_MONTH);
		fmonth = cal.get(Calendar.MONTH);
		days = new int[42];
		cal.set(vdate.year, vdate.month-1, 1); //reinitialise calendar
		cal.getTime(); //fucking explain that - without it the next line is processed incorrectly
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //first element in the table
		System.out.println(cal.getTime());
		int counter = 0;
		while (counter < 42) {
		days[counter] = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		if (cal.get(Calendar.MONTH) == vdate.month-1 && days[counter] == vdate.day) {
			selr = counter/7;
			selc = counter%7;
		}
		counter++;
		}
	}
	
	public void setSelectedCell (int r, int c) {
		selr = r;
		selc = c;
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
				return days[7*row+col];
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
		
		monthTable.doLayout();
				
		JScrollPane scrollpane = new JScrollPane(monthTable);
		//scrollpane.setSize(panel.getSize());
		
		JLabel monthLabel = new JLabel(vmonth);

		JTable rowTable = new RowNumberTable(monthTable, fweek);
		//rowTable.setPreferredSize(new Dimension(panel.getWidth()/8, panel.getHeight()));
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,	rowTable.getTableHeader());
		

		monthTable.changeSelection(selr, selc, false, false);

		//panel.add(monthLabel);
		panel.add(scrollpane);
	}
}
