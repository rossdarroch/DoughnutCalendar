import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import calendar_ex.*;

public class WeeklyView extends AndroidWindow implements ActionListener {
	private Container jpanel;
	
	private String vmonth;
	private int fweek, fday, fmonth, selr, selc;
	private Context c;
	private CalendarDate vdate, cdate;
	private int[] days;

	public WeeklyView() {
		super();
		c = Context.getContext();
		weekTime(c.getViewDate());
	}
	
	public void weekTime(CalendarDate newDate){
		
		//cdate = c.getCurrentDate();
		//vmonth = CalendarDate.getMonth(newDate.month);
		vdate = c.getViewDate();
		GregorianCalendar cal = new GregorianCalendar(newDate.year, newDate.month-1, 1);
		fweek = cal.get(Calendar.WEEK_OF_YEAR);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		fday = cal.get(Calendar.DAY_OF_MONTH);
		fmonth = cal.get(Calendar.MONTH);
		days = new int[42];
		cal.set(newDate.year, newDate.month-1, 1); 
		cal.getTime(); 
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(cal.getTime());
		/*int counter = 0;
		while (counter < 42) {
		days[counter] = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		if (cal.get(Calendar.MONTH) == newDate.month-1 && days[counter] == newDate.day) {
			selr = counter/7;
			selc = counter%7;
		}
		counter++;
		}*/
	}

	public void setSelectedCell (int r, int c) {
		selr = r;
		selc = c;
	}

	@SuppressWarnings("serial")
	static class CellRenderer extends DefaultTableCellRenderer {

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			JLabel renderedLabel = (JLabel) super
					.getTableCellRendererComponent(table, value, isSelected,
							hasFocus, row, column);
			renderedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			return renderedLabel;
		}
	}
	
	private List<Appointment> getApt(CalendarDate date1, CalendarDate date2){
		List<Appointment> aptl = new ArrayList<Appointment>();
		//aptl = CalendarEx.getAppointmentsBetweenDates(date1, date2);
		return aptl;
		
	}

	@SuppressWarnings("serial")
	public void setup(JPanel panel) {
		jpanel = panel;
		@SuppressWarnings("serial")
		TableModel dataModel = new AbstractTableModel() {
			String[] week = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				return 24;
			}

			public String getColumnName(int col) {
				return week[col];
			}

			@SuppressWarnings("static-access")
			public Object getValueAt(int row, int col) {
			/*	CalendarDate ndate = vdate;
				int ndateID = ndate.getDateID(ndate);
				ndateID += 7;
				ndate = ndate.getDateFromID(ndateID);
				List<Appointment> nlist = new ArrayList<Appointment>();
				nlist = getApt(vdate, ndate);
				
				int rc = getRowCount();
				int cc = getColumnCount();
				
				//create buttons for every cell in table
				 * add create appointment listener
				
				//if appointment is during week
				while (nlist.listIterator() != null){
					//display appointment on button
					 * add edit appointment listener
				}*/
	
				
				return "";
				
			}
		};
		
		JTable weekTable = new JTable(dataModel);
		weekTable.setDefaultRenderer(Object.class, new CellRenderer());
		weekTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		weekTable.setRowSelectionAllowed(false);
		weekTable.setCellSelectionEnabled(true);
		weekTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		weekTable.setRowHeight(100);
		weekTable.setPreferredScrollableViewportSize(new Dimension(panel
				.getWidth() - 100, panel.getHeight() - 200));

		weekTable.changeSelection(selr, selc, false, false);
		weekTable.doLayout();

		JScrollPane scrollpane = new JScrollPane(weekTable);

		JTable rowTable = new RowNumberTable(weekTable, 0);
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
				rowTable.getTableHeader());
		
		//weekTable.changeSelection(selr, selc, false, false);
		jpanel.add(scrollpane);
		init();
	}

	private void init() {
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		JButton prevWeekButton = new JButton("<");
		prevWeekButton.setSize(100, 25);
		prevWeekButton.setActionCommand("previous");
		prevWeekButton.addActionListener(this);

		//Context c = Context.getContext();
		JLabel weekDisplay = new JLabel("        " + vdate.toString());
		weekDisplay.setSize(100, 25);
		weekDisplay.setHorizontalTextPosition(SwingConstants.CENTER);

		JButton nextWeekButton = new JButton(">");
		nextWeekButton.setActionCommand("next");
		nextWeekButton.setSize(100, 25);
		nextWeekButton.addActionListener(this);

		JPanel nav_panel = new JPanel();
		nav_panel.setLayout(new GridLayout(1, 3));
		nav_panel.setSize(480, 25);
		nav_panel.add(prevWeekButton);
		nav_panel.add(weekDisplay);
		nav_panel.add(nextWeekButton);

		// TODO: add real calendar view
		jpanel.add(nav_panel);

	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		if ("previous".equals(e.getActionCommand())) {
			CalendarDate pdate = vdate;
			int ndateID = pdate.getDateID(pdate);
			ndateID -= 7;
			pdate = pdate.getDateFromID(ndateID);
			c.setViewDate(pdate);
			weekTime(pdate);
		}
		;
		if ("next".equals(e.getActionCommand())) {
			//int vdateID = CalendarDate.getDateID(vdate);
			CalendarDate ndate = vdate;
			int ndateID = ndate.getDateID(ndate);
			ndateID += 7;
			ndate = ndate.getDateFromID(ndateID);
			c.setViewDate(ndate);
			weekTime(ndate);
		}
		
		// TODO: load next week appointments for display
		if ("newEvent".equals(e.getActionCommand())) {
			new CreateAppointment();
		}
		;
	}

}