
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public abstract class AndroidWindow {
	
	public void BackButtonPressed(JPanel content, ActionEvent e) {
		JOptionPane.showMessageDialog(content, "Not implemented");
	}
	
	public void MenuButtonPressed(JPanel content, ActionEvent e) {
		JFrame views = new JFrame();
		views.setTitle("What to Do");
		views.setSize(400, 200);
		views.setLocationRelativeTo(null); // center the "Android"
		views.setLayout(new GridLayout(2,3));

		SwitchViewButton<AndroidWindow, MakeDailyView > day =
				new SwitchViewButton<AndroidWindow, MakeDailyView>(new MakeDailyView(), "1 day", content);
		SwitchViewButton<AndroidWindow, MakeWeeklyView > week =
				new SwitchViewButton<AndroidWindow, MakeWeeklyView>(new MakeWeeklyView(), "7 week", content);
		SwitchViewButton<AndroidWindow, MakeMonthlyView > month =
				new SwitchViewButton<AndroidWindow, MakeMonthlyView>(new MakeMonthlyView(), "31 month", content);
		
		Font f = H.font(1.5);
		JButton addnew = new JButton("Add New"); addnew.setFont(f);
		JButton today = new JButton("Today"); today.setFont(f);
		JButton calendars = new JButton("Calendars"); calendars.setFont(f);

		views.add(day); views.add(week); views.add(month);
		views.add(addnew); views.add(today); views.add(calendars);
		
		views.setVisible(true);
		
	}
	
	class SwitchViewButton<Window extends AndroidWindow, Maker extends Make<AndroidWindow> > extends JButton implements ActionListener {
		private static final long serialVersionUID = -8940976060867826100L;
		private Maker maker;
		private JPanel content;

		SwitchViewButton(Maker ma, String label, JPanel content) {
			super(label);
			addActionListener(this);
			setFont(H.font(1.5));
			this.content = content;
			maker = ma;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AndroidWindow inst = maker.make();
			inst.setup(this.content);
		}
		
	}
	
	public void HomeButtonPressed(JPanel content, ActionEvent e) {
		JOptionPane.showMessageDialog(content, "Not implemented");
	}
	public void SearchButtonPressed(JPanel content, ActionEvent e) {
		JOptionPane.showMessageDialog(content, "Not implemented");
	}
	/*
	 * Sets up the environment
	 */
	public abstract void setup(Container panel);
}
