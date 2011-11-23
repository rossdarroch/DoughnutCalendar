import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;

public class CreateAppointment extends AppointmentHandler {

	public void setup(JPanel panel) {
		super.setup(panel);
		JPanel fromTimePopupPanel = (new TimePopup(fromTimeField)).getJPanel();
		fromTimePopupPanel.addMouseListener(new PopupPanelListener(fromTimePopup));
		fromTimeField.addMouseListener(new timeFieldListener(fromTimePopup,
				fromTimeField, fromTimePopupPanel));
		

		// toTimeField.addMouseListener(new timeFieldListener(toTimePopup));
	}

	private class saveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			CreateAppointment source = (CreateAppointment) ae.getSource();
			// Appointment ap = new Appointment(source.fromField)
		}

	}

	public class TimePopup {

		// Popup popup;
		JTextField owner;

		JPanel jpanel;

		JTextField hourField;
		JButton plusHourButton;
		JButton minusHourButton;

		JTextField minuteField;
		JButton plusMinuteButton;
		JButton minusMinuteButton;

		public TimePopup(JTextField o) {
			owner = o;
			// popup = p;

			jpanel = new JPanel();
			jpanel.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.BLACK, 2),
					BorderFactory.createEmptyBorder(8, 8, 8, 8)));
			// jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.LINE_AXIS));
			// jpanel.add(Box.createRigidArea(new Dimension(10, 0)));

			// hourPanel = new JPanel();
			// hourPanel.setLayout(new BoxLayout(hourPanel,
			// BoxLayout.PAGE_AXIS));
			jpanel.setLayout(new GridLayout(3, 3, 5, 5));
			plusHourButton = new JButton("+");
			plusHourButton.setFont(H.font());

			hourField = new JTextField(o.getText().substring(0, 2));
			hourField.setHorizontalAlignment(JTextField.CENTER);
			hourField.setEditable(false);
			hourField.setFont(H.font());
			minusHourButton = new JButton("-");
			minusHourButton.setFont(H.font());

			plusMinuteButton = new JButton("+");
			plusMinuteButton.setFont(H.font());
			minuteField = new JTextField(o.getText().substring(3, 5));
			minuteField.setHorizontalAlignment(JTextField.CENTER);
			minuteField.setEditable(false);
			minuteField.setFont(H.font());
			minusMinuteButton = new JButton("-");
			minusMinuteButton.setFont(H.font());

			jpanel.add(plusHourButton);
			jpanel.add(new JLabel(""));
			jpanel.add(plusMinuteButton);
			jpanel.add(hourField);
			JLabel colonLabel = new JLabel(":");
			colonLabel.setFont(H.font());
			colonLabel.setHorizontalAlignment(JLabel.CENTER);
			jpanel.add(colonLabel);
			jpanel.add(minuteField);
			jpanel.add(minusHourButton);
			jpanel.add(new JLabel(""));
			jpanel.add(minusMinuteButton);

			plusHourButton.addActionListener(new timePopupListener());
			minusHourButton.addActionListener(new timePopupListener());
			plusMinuteButton.addActionListener(new timePopupListener());
			minusMinuteButton.addActionListener(new timePopupListener());

			// jpanel.add(hourPanel);
		}

		public JPanel getJPanel() {
			return jpanel;
		}

		public class timePopupListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int hourInt;
				if (ae.getSource() == plusHourButton) {
					hourInt = Integer.valueOf(hourField.getText());
					hourField.setText(Integer.toString(++hourInt));
					owner.setText(hourField.getText()
							+ owner.getText().substring(2));
				}
			}

		}

	}

	public class timeFieldListener implements MouseListener {

		// TimePopup timePopup;
		Popup popup;
		JTextField owner;
		JPanel popupPanel;

		// @Override
		// public void focusGained(FocusEvent fe) {
		// // CreateAppointment ca = (CreateAppointment) arg0.getSource();
		// owner = (JTextField) fe.getComponent();
		// Point pt = owner.getLocation();
		// SwingUtilities.convertPointToScreen(pt, owner);
		// pop = PopupFactory.getSharedInstance().getPopup(owner,
		// (new TimePopup(owner)).getJPanel(), pt.x - 200, pt.y - 100);
		// pop.show();
		// }
		//
		// @Override
		// public void focusLost(FocusEvent arg0) {
		// pop.hide();
		// }

		public timeFieldListener(Popup p, JTextField o, JPanel pPanel) {
			popup = p;
			owner = o;
			popupPanel = pPanel;
		}

		@Override
		public void mouseClicked(MouseEvent me) {
			Point pt = owner.getLocation();
			SwingUtilities.convertPointToScreen(pt, owner);
			popup = PopupFactory.getSharedInstance().getPopup(owner,
					popupPanel, pt.x - 200, pt.y - 100);
			popup.show();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}

	public class PopupPanelListener implements MouseListener {
		Popup popup;

		public PopupPanelListener(Popup p) {
			popup = p;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
			popup.hide();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}
}
