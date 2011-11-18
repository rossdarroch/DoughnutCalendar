
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import javax.swing.JTable;

public class DailyView extends AndroidWindow implements ActionListener {
	private Container jPanel;

	@Override
	public void setup(Container panel) {
		TableModel dataModel = new AbstractTableModel() {
			private static final long serialVersionUID = 89037589235789234L;
			private int[] hours = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,29,20,21,22,23};
			public int getColumnCount() {
				return 2;
			}

			public int getRowCount() {
				return 10;
			}

			public Object getValueAt(int row, int col) {
				return new Integer(row * col);
			}
		};
		//panel.setSize(480, 800 + 100);
		JTable DailyTable = new JTable(dataModel);
		DailyTable.setSize(480,1200);
		DailyTable.setRowSelectionAllowed(false);
		DailyTable.setCellSelectionEnabled(true);
        DailyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DailyTable.doLayout();

		JScrollPane scrolling = new JScrollPane(DailyTable);

		JTable rowTable = new RowNumberTable(DailyTable, 0);
		scrolling.setRowHeaderView(rowTable);
		scrolling.setCorner(JScrollPane.UPPER_LEFT_CORNER,
		    rowTable.getTableHeader());
        panel.add(scrolling);
        panel.add(rowTable);

        JButton prevDayButton = new JButton("<");
        prevDayButton.setActionCommand("previous");
        prevDayButton.addActionListener(this);
        JButton nextDayButton = new JButton(">");
        nextDayButton.setActionCommand("next");
        nextDayButton.addActionListener(this);

        JPanel nav_panel = new JPanel();
        nav_panel.setLayout(new GridLayout(1, 3));
        nav_panel.add(prevDayButton);
        nav_panel.add(nextDayButton);
        panel.add(nav_panel);
        }

    public void actionPerformed(ActionEvent e) {
         if ("previous".equals(e.getActionCommand())) {
                 new WeeklyView();
         }
         if ("next".equals(e.getActionCommand())) {
                 new WeeklyView();
         }
    }
}