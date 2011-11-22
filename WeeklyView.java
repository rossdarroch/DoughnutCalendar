import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import calendar_ex.CalendarDate;

public class WeeklyView extends AndroidWindow implements ActionListener {
	private Container jpanel;
	private String[] week = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
	private String vmonth;
	private int fweek, fday, fmonth;
	private Context c;
	private CalendarDate vdate;

	public WeeklyView() {
		super();
		c = Context.getContext();
		vdate = c.getViewDate();
		vmonth = CalendarDate.getMonth(vdate.month);
		GregorianCalendar cal = new GregorianCalendar(vdate.year, vdate.month,
				vdate.day);
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

	public void setup(Container panel) {
		jpanel = panel;

		@SuppressWarnings("serial")
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				return 24;
			}

			public String getColumnName(int col) {
				return week[col];
			}

			public Object getValueAt(int row, int col) {
				// GregorianCalendar cal = new GregorianCalendar(vdate.year,
				// vdate.month, 1);
				// cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				// cal.add(Calendar.DAY_OF_MONTH, 7*row+col-1);
				// return cal.get(Calendar.DAY_OF_MONTH);

				// private CalendarDate wDate = new
				// getAppointmentsBetweenDates(vdate, )
				return " ";
				// if already appointment, return editappointment; else
				// return new CreateAppointment();
			}
		};

		JTable weekTable = new JTable(dataModel);
		weekTable.setDefaultRenderer(Object.class, new CellRenderer());
		weekTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		weekTable.setRowSelectionAllowed(false);
		weekTable.setCellSelectionEnabled(true);
		weekTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		weekTable.setRowHeight(60);
		weekTable.setPreferredScrollableViewportSize(new Dimension(panel
				.getWidth() - 100, panel.getHeight() - 250));

		weekTable.doLayout();

		JScrollPane scrollpane = new JScrollPane(weekTable);

		JTable rowTable = new RowNumberTable(weekTable, 0);
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
				rowTable.getTableHeader());
		jpanel.add(scrollpane);
		init();
	}

	private void init() {
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		JButton prevWeekButton = new JButton("<");
		prevWeekButton.setSize(100, 25);
		prevWeekButton.setActionCommand("previous");
		prevWeekButton.addActionListener(this);

		Context c = Context.getContext();
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

	public void actionPerformed(ActionEvent e) {
		if ("previous".equals(e.getActionCommand())) {
			int dateID = CalendarDate.getDateID(vdate) - 7;
			CalendarDate newDate = new CalendarDate(dateID);
			vdate = newDate;
			new WeeklyView();

		}
		;
		if ("next".equals(e.getActionCommand())) {
			int dateID = CalendarDate.getDateID(vdate) + 7;
			CalendarDate newDate = new CalendarDate(dateID);
			vdate = newDate;
			new WeeklyView();
			// TODO: load next week appointments for display
		}
		if ("newEvent".equals(e.getActionCommand())) {
			new CreateAppointment();
		}
		;
	}
}