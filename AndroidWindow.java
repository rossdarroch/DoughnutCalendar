
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
	private JFrame views = new JFrame();
	SwitchViewButton<AndroidWindow, MakeDailyView > dayButton;
	SwitchViewButton<AndroidWindow, MakeWeeklyView > weekButton;
	SwitchViewButton<AndroidWindow, MakeMonthlyView > monthButton;
	
	
	public AndroidWindow() {
		views.setTitle("What to Do");
		views.setSize(400, 200);
		views.setLocationRelativeTo(null); // center the "Android"
		views.setLayout(new GridLayout(2,3));
		
		Font f = H.font(1.5);
		JButton addnew = new JButton("Add New"); addnew.setFont(f);
		JButton today = new JButton("Today"); today.setFont(f);
		JButton calendars = new JButton("Calendars"); calendars.setFont(f);

		views.add(addnew); views.add(today); views.add(calendars);
	}
	
	public void BackButtonPressed(JPanel content, ActionEvent e) {
		JOptionPane.showMessageDialog(content, "Not implemented");
	}
	
	public void MenuButtonPressed(JPanel content, ActionEvent e) {
		dayButton =
				new SwitchViewButton<AndroidWindow, MakeDailyView>(new MakeDailyView(), "1 day", content);
		weekButton =
				new SwitchViewButton<AndroidWindow, MakeWeeklyView>(new MakeWeeklyView(), "7 week", content);
		monthButton =
				new SwitchViewButton<AndroidWindow, MakeMonthlyView>(new MakeMonthlyView(), "31 month", content);
		views.add(dayButton); views.add(weekButton); views.add(monthButton);
		views.setVisible(true);
	}
	
	public void HideMenu(){
		views.setVisible(false);
		views.remove(dayButton);
		views.remove(weekButton);
		views.remove(monthButton);
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
			this.content.removeAll();
			inst.setup(this.content);
			HideMenu();
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
	public abstract void setup(JPanel panel);
}
