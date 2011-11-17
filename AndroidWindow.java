import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class AndroidWindow {
	public void BackButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}
	
	public void MenuButtonPressed(JFrame frame, ActionEvent e) {
		JFrame views = new JFrame();
		views.setTitle("What to Do");
		views.setSize(400, 200);
		views.setLocationRelativeTo(null); // center the "Android"
		views.setLayout(new GridLayout(2,3));

		Font f = H.font(1.5);
		JButton day = new JButton("1 Day"); day.setFont(f);
		JButton week = new JButton("7 Week"); week.setFont(f);
		JButton month = new JButton("31 Month"); month.setFont(f);

		JButton addnew = new JButton("Add New"); addnew.setFont(f);
		JButton today = new JButton("Today"); today.setFont(f);
		JButton calendars = new JButton("Calendars"); calendars.setFont(f);

		views.add(day); views.add(week); views.add(month);
		views.add(addnew); views.add(today); views.add(calendars);
		views.setVisible(true);
	}
	
	public void HomeButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}
	public void SearchButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}
	/*
	 * Sets up the environment
	 */
	public abstract void setup(Container panel);
}
