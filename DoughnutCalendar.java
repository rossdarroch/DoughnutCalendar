import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class DoughnutCalendar {
	AndroidWindow win;
	JFrame frame;

	/*
	 * Comments on Layout
	 * 
	 * Android phone is 480*800px
	 * 
	 * We put 100px for 4 bottom buttons. Bottom buttons are not part of the
	 * screen, so we add 100px to the Root window. Therefore root window is
	 * 480*900px.
	 * 
	 * Header takes 70px (now just a clock). These pixels are taken away from
	 * the "real" 800px -- therefore we have 730px for JPanel content.
	 * 
	 * JPanel content is wrapped in a JScrollPane, so you can increase the
	 * vertical size of content arbitrarily. If content height is more than
	 * 730px, scroll bars will appear ("sliding" emulation).
	 * 
	 * This means all apps must fit to 480px width (forced restriction) and
	 * any height, but only 730px are visible at once.
	 */
	public DoughnutCalendar() {
		frame = new JFrame();

		frame.setTitle("Nexus Sieben");

		// 70px for header, 730px for content, 100px for buttons
		frame.setSize(480, 730 + 70 + 100);
		frame.setLocationRelativeTo(null); // center the "Android"
		frame.setLayout(new BorderLayout());

		JPanel content = new JPanel();
		content.setSize(480, 730);
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Container content_wrapper = new JScrollPane(content);
		JComponent buttons = new JPanel();
		buttons.setBorder(BorderFactory.createLineBorder(Color.black));

		JComponent header = new JPanel(
				new FlowLayout(FlowLayout.TRAILING, 1, 0));
		header.add(new ClockLabel());
		header.setSize(480, 70);

		win = new MonthlyView();
		win.setup(content);

		JButton back = new JButton("Back");
		back.addActionListener(new BackButtonHandler());
		buttons.add(back);
		JButton menu = new JButton("Menu");
		menu.addActionListener(new MenuButtonHandler());
		buttons.add(menu);
		JButton home = new JButton("Home");
		home.addActionListener(new HomeButtonHandler());
		buttons.add(home);
		JButton search = new JButton("Search");
		search.addActionListener(new SearchButtonHandler());
		buttons.add(search);

		frame.add(header, BorderLayout.PAGE_START);
		frame.add(content_wrapper, BorderLayout.CENTER); // center
		frame.add(buttons, BorderLayout.PAGE_END); // bottom

		// pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new DoughnutCalendar();
	}

	private class BackButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			win.BackButtonPressed(frame, e);
		}
	}

	private class MenuButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			win.MenuButtonPressed(frame, e);
		}
	}

	private class HomeButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			win.HomeButtonPressed(frame, e);
		}
	}

	private class SearchButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			win.SearchButtonPressed(frame, e);
		}
	}

	private class ClockLabel extends JLabel implements ActionListener {
		public ClockLabel() {
			super();
			changeDate();
			Timer t = new Timer(1000, this);
			t.start();
		}

		private void changeDate() {
			Date now = new Date();
			String h = new SimpleDateFormat("H").format(now);
			String m = new SimpleDateFormat("m").format(now);
			String s = new SimpleDateFormat("s").format(now);
			h = h.length() == 1 ? "0" + h : h;
			m = m.length() == 1 ? "0" + m : m;
			s = s.length() == 1 ? "0" + s : s;
			setText(h + ":" + m + ":" + s);
		}

		public void actionPerformed(ActionEvent ae) {
			changeDate();
		}
	}

}
