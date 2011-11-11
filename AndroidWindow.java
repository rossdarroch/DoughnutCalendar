import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class AndroidWindow {
	public void BackButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
	}
	public void MenuButtonPressed(JFrame frame, ActionEvent e) {
		JOptionPane.showMessageDialog(frame, "Not implemented");
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
	public abstract void setup(JPanel panel);
}
