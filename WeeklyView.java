import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeeklyView extends AndroidWindow {
	private JPanel jpanel;

	public void setup(JPanel panel) {
		jpanel = panel;
		init();
	}

	private void init() {
		JButton prevWeekButton = new JButton("<");
		JButton nextWeekButton = new JButton(">");
		JPanel nav_panel= new JPanel();
	    nav_panel.setLayout(new GridLayout(1,3));
	    nav_panel.add(prevWeekButton); 
	    nav_panel.add(nextWeekButton);

		// TODO: add real calendar view
		jpanel.add(nav_panel);
	}

	public void BackButtonPressed(JFrame frame, ActionEvent e) {
	}

}