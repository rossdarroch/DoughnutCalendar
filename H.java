import java.awt.Font;

import javax.swing.JLabel;


public class H {
	// Helper to get a Font of "size" em 

	public static Font font(double size) {
		JLabel l = new JLabel("X");
		return new Font(
				l.getFont().getFontName(),
				l.getFont().getStyle(),
				(int)(size*l.getFont().getSize()));
	}
	// This is the default font for the calendar
	public static Font font() {
		return font(3);
	}
}
