import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class WeeklyView extends AndroidWindow implements ActionListener {
	private Container jpanel;
	private String[] week = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

	public void setup(Container panel) {
		jpanel = panel;

		@SuppressWarnings("serial")
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				return 24; // 8
			}

			public String getColumnName(int col) {
				return week[col];
			}

			public Object getValueAt(int row, int col) {
				return new Integer(row * col);
			}
		};
		jpanel.setSize(480, 800 + 100);
		JTable weekTable = new JTable(dataModel);
		weekTable.setSize(480, 800 + 100);
		weekTable.setRowSelectionAllowed(false);
		weekTable.setCellSelectionEnabled(true);
		weekTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// weekTable.setPreferredScrollableViewportSize(new Dimension(480,
		// 800));
		weekTable.doLayout();
		JScrollPane scrollpane = new JScrollPane(weekTable);

		JTable rowTable = new RowNumberTable(weekTable, 24);
		scrollpane.setRowHeaderView(rowTable);
		scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
				rowTable.getTableHeader());
		jpanel.add(scrollpane);
		jpanel.add(rowTable);
		init();
	}

	private void init() {
		JButton prevWeekButton = new JButton("<");
		prevWeekButton.setActionCommand("previous");
		prevWeekButton.addActionListener(this);

		JButton nextWeekButton = new JButton(">");
		nextWeekButton.setActionCommand("next");
		nextWeekButton.addActionListener(this);

		JPanel nav_panel = new JPanel();
		nav_panel.setLayout(new GridLayout(1, 3));
		nav_panel.add(prevWeekButton);
		nav_panel.add(nextWeekButton);

		// TODO: add real calendar view
		jpanel.add(nav_panel);

	}

	public void actionPerformed(ActionEvent e) {
		if ("previous".equals(e.getActionCommand())) {
			new WeeklyView();
		}
		;
		if ("next".equals(e.getActionCommand())) {
			new WeeklyView();
		}
		;
	}

	public void BackButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}

	public void MenuButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}

	public void HomeButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}

	public void SearchButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}
}