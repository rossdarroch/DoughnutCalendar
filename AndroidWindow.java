import javax.swing.JFrame;

public interface AndroidWindow {
	public void BackButtonPressed();
	public void SettingsButtonPressed();
	public void HomeButtonPressed();
	/*
	 * Sets up the environment and control is passed to you.
	 */
	public void start(JFrame frame);
}
