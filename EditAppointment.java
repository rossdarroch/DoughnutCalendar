import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimeZone;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditAppointment extends AppointmentHandler {

	private JButton editButton;
	private JButton deleteButton;
	// boolean that checks if setupMore is executed
	private boolean moreEnabled;
	
	public EditAppointment() {
		moreEnabled = false;
	}

	@Override
	public void setup(JPanel panel) {
		super.setup(panel);

		eventField.setEditable(false);
		toField.setEditable(false);
		toTimeField.setEditable(false);
		fromField.setEditable(false);
		fromTimeField.setEditable(false);
		locationField.setEditable(false);

		// Stubs to be deleted
		eventField.setText("Wake Up!!!");
		locationField.setText("Bed");

		GridLayout buttonsLayout = (GridLayout) buttonsPanel.getLayout();
		buttonsLayout.setRows(2);

		// JPanel extraButtonsPanel = new JPanel();
		// extraButtonsPanel.setLayout(new BoxLayout(extraButtonsPanel,
		// BoxLayout.LINE_AXIS));
		// extraButtonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		editButton = new JButton("Edit");
		editButton.setFont(font);
		editButton.addActionListener(new EditButtonListener());
		deleteButton = new JButton("Delete");
		deleteButton.setFont(font);
		// buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(editButton);
		// extraButtonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonsPanel.add(deleteButton);
		// buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		// panel.add(Box.createRigidArea(new Dimension(0, 10)));
		// panel.add(extraButtonsPanel);
		buttonsPanel.setMaximumSize(buttonsPanel.getPreferredSize());
	}

	public void setupMore() {
		// panel.remove(buttonsWrapPanel);
		if (!moreEnabled) {
			moreEnabled = true;
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			JLabel timeZoneLabel = new JLabel("Time Zone");
			timeZoneLabel.setFont(H.font());
			String timeZones[] = { TimeZone.getDefault().getDisplayName(), "blah" };
			JComboBox timeZoneField = new JComboBox(timeZones);
			timeZoneField.setFont(H.font());
			timeZoneField.setAlignmentX(Component.LEFT_ALIGNMENT);
			timeZoneField.setMaximumSize(timeZoneField.getPreferredSize());
			timeZoneField.setEnabled(false);
			fieldsPanel.add(timeZoneLabel);
			fieldsPanel.add(timeZoneField);
		}

	}

	public class EditButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setupMore();
		}

	}

}
