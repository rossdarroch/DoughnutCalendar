import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
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

	public DoughnutCalendar() {
		frame = new JFrame();

		frame.setTitle("Nexus Sieben");
		frame.addWindowListener(new WinHandler());

		// 800px for content, 100px for buttons
		frame.setSize(480, 800 + 100);
		frame.setLocationRelativeTo(null); // center
		frame.setLayout(new BorderLayout());

		JPanel content = new JPanel();
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Container content_wrapper = new JScrollPane(content);
		JComponent buttons = new JPanel();
		buttons.setBorder(BorderFactory.createLineBorder(Color.black));

		JComponent header = new JPanel(
				new FlowLayout(FlowLayout.TRAILING, 1, 0));
		header.add(new ClockLabel());
		header.setSize(480, 70);

		win = new WeeklyView();
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

	private class WinHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			frame.dispose();
			System.exit(0);
		}
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
			h = h.length() == 1? "0" + h : h;
			m = m.length() == 1? "0" + m : m;
			s = s.length() == 1? "0" + s : s;
			setText(h + ":" + m + ":" + s);
		}
		public void actionPerformed(ActionEvent ae) {
			changeDate();
		}
	}

}
