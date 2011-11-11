import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoughnutCalendar extends JFrame implements ActionListener, WindowListener {
	private static final long serialVersionUID = 3827356193478438879L;

	AndroidWindow win;
	JFrame frame;
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public DoughnutCalendar() {
		frame = this;
	    setTitle("Nexus Sieben");
	    addWindowListener(new WinHandler());

	    // 800px for content, 200px for buttons
	    setSize(480, 800+100);
	    setLocationRelativeTo(null); // center
	    this.setLayout(new BorderLayout());
	    
	    JPanel content = new JPanel();
	    JPanel buttons = new JPanel();
	    buttons.setBorder(BorderFactory.createLineBorder(Color.black));

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
	    
	    this.add(content, BorderLayout.CENTER); // center
	    this.add(buttons, BorderLayout.PAGE_END); // bottom


	    //pack();
	    setVisible(true);
	}
	

	public static void main(String[] args) {
		new DoughnutCalendar();
		
	}
	private class WinHandler extends WindowAdapter  {
	    public void windowClosing (WindowEvent e) { dispose(); System.exit(0); }
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
