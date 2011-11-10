import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class DoughnutCalendar extends JFrame implements ActionListener, WindowListener {
	private static final long serialVersionUID = 3827356193478438879L;

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
	    setTitle("Nexus Sieben");
	    addWindowListener(new WinHandler());

	    setSize(480, 800);
	    setLocationRelativeTo(null); // center
	    pack();
	    setVisible(true);
	}
	

	public static void main(String[] args) {
		new DoughnutCalendar();
		
	}
	private class WinHandler extends WindowAdapter  {
	    public void windowClosing (WindowEvent e) { dispose(); System.exit(0); }
	}

}
