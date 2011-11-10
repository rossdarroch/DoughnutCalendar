import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeeklyView implements AndroidWindow {
	private JFrame jframe;
	
	public void BackButtonPressed() {
	}

	public void SettingsButtonPressed() {
	}

	public void HomeButtonPressed() {
	}

	public void start(JFrame frame) {
		jframe = frame;
		init();
	}

	private void init() {
		JButton prevWeekButton = new JButton("<");
		JButton nextWeekButton = new JButton(">");
		JPanel nav_panel= new JPanel();
	    nav_panel.setLayout(new GridLayout(1,3));
	    nav_panel.add(prevWeekButton); 
	    nav_panel.add(nextWeekButton);

		Container pan = jframe.getContentPane();

		// TODO: add real calendar view
		pan.add(nav_panel);

	}
}
