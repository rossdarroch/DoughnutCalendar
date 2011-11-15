import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class WeeklyView extends AndroidWindow {
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
                return 24; //8
            }

            public String getColumnName(int col) {
                return week[col];
            }

            public Object getValueAt(int row, int col) {
                return new Integer(row * col);
            }
        };
        
        JTable weekTable = new JTable(dataModel);
        weekTable.setRowSelectionAllowed(false);
        weekTable.setCellSelectionEnabled(true);
        weekTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //weekTable.setPreferredScrollableViewportSize(new Dimension(480, 800));
        weekTable.doLayout();
        JScrollPane scrollpane = new JScrollPane(weekTable);

        JTable rowTable = new RowNumberTable(weekTable, 45);
        scrollpane.setRowHeaderView(rowTable);
        scrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
        jpanel.add(scrollpane);
        jpanel.add(rowTable);
        init();
    }

    private void init() {
        JButton prevWeekButton = new JButton("<");
        JButton nextWeekButton = new JButton(">");
        JPanel nav_panel = new JPanel();
        nav_panel.setLayout(new GridLayout(1, 3));
        nav_panel.add(prevWeekButton);
        nav_panel.add(nextWeekButton);

        // TODO: add real calendar view
        jpanel.add(nav_panel);
        
    }

    public void BackButtonPressed(JFrame frame, ActionEvent e) {
    }
}
