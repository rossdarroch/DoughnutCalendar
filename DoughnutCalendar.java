import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class DoughnutCalendar {
	private static final long serialVersionUID = 3827356193478438879L;

	AndroidWindow win;
	JFrame frame;

	public DoughnutCalendar() {
		frame = new JFrame();
		
	    frame.setTitle("Nexus Sieben");
	    frame.addWindowListener(new WinHandler());

	    // 800px for content, 100px for buttons
	    frame.setSize(480, 800+100);
	    frame.setLocationRelativeTo(null); // center
	    frame.setLayout(new BorderLayout());
	    
	    
	    JPanel content = new JPanel();
	    content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    Container content_wrapper = new JScrollPane(content);
	    //content_wrapper.add(content);
	    JComponent buttons = new JPanel();
	    buttons.setBorder(BorderFactory.createLineBorder(Color.black));

	    win = new CreateAppointment();
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
	    
	    frame.add(content_wrapper, BorderLayout.CENTER); // center
	    frame.add(buttons, BorderLayout.PAGE_END); // bottom


	    //pack();
	    frame.setVisible(true);
	}

	public static void main(String[] args) {
		new DoughnutCalendar();
	}
	private class WinHandler extends WindowAdapter  {
	    public void windowClosing (WindowEvent e) { frame.dispose(); System.exit(0); }
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
}
