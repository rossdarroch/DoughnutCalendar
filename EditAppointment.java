import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimeZone;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditAppointment extends AppointmentHandler {

	private JButton editButton;
	private JButton deleteButton;
	// boolean that checks if edit has already been executed
	private boolean editEnabled;
	
	public EditAppointment() {
		editEnabled = false;
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

	public void edit() {
		// panel.remove(buttonsWrapPanel);
		if (!editEnabled) {
			editEnabled = true;
			
			// enable fields 
			eventField.setEditable(true);
			toField.setEditable(true);
			toTimeField.setEditable(true);
			fromField.setEditable(true);
			fromTimeField.setEditable(true);
			locationField.setEditable(true);
			
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
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			fieldsPanel.add(timeZoneField);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
			JLabel descriptionLabel = new JLabel("Description");
			descriptionLabel.setFont(H.font());
			JTextArea descriptionField = new JTextArea(3, 12);
			descriptionField.setFont(H.font());
			descriptionField.setLineWrap(true);
			descriptionField.setWrapStyleWord(true);
			JScrollPane descriptionFieldJSP = new JScrollPane(descriptionField);
			descriptionFieldJSP.setMaximumSize(descriptionField.getPreferredSize());
			descriptionFieldJSP.setAlignmentX(Component.LEFT_ALIGNMENT);
			fieldsPanel.add(descriptionLabel);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			fieldsPanel.add(descriptionFieldJSP);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
			JLabel calendarLabel = new JLabel("Calendar");
			calendarLabel.setFont(H.font());
			// calendarList to be replaced
			String calendarList[] = {"calendar1", "calendar2"};
			JComboBox calendarField = new JComboBox(calendarList);
			calendarField.setFont(H.font());
			calendarField.setAlignmentX(Component.LEFT_ALIGNMENT);
			calendarField.setMaximumSize(calendarField.getPreferredSize());
			fieldsPanel.add(calendarLabel);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			fieldsPanel.add(calendarField);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
			JLabel reminderLabel = new JLabel("Remind me");
			reminderLabel.setFont(H.font());
			String reminderList[] = {"No reminder", "5 minutes", "10 minutes", "15 minutes", "30 minutes", "1 hour", 
					"2 hours", "3 hours", "6 hours", "12 hours", "1 day", "2 days", "1 week"};
			JComboBox reminderField = new JComboBox(reminderList);
			reminderField.setFont(H.font());
			reminderField.setAlignmentX(Component.LEFT_ALIGNMENT);
			reminderField.setMaximumSize(reminderField.getPreferredSize());
			fieldsPanel.add(reminderLabel);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			fieldsPanel.add(reminderField);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
			JLabel repeatLabel = new JLabel("Repeats");
			repeatLabel.setFont(H.font());
			String repeatList[] = {"No repeat", "Daily", "Weekly", "Monthly", "Yearly"};
			JComboBox repeatField = new JComboBox(repeatList);
			repeatField.setFont(H.font());
			repeatField.setAlignmentX(Component.LEFT_ALIGNMENT);
			repeatField.setMaximumSize(reminderField.getPreferredSize());
			fieldsPanel.add(repeatLabel);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			fieldsPanel.add(repeatField);
			fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
			JCheckBox allDay = new JCheckBox("All day");
			allDay.setFont(H.font());
			fieldsPanel.add(allDay);
		}

	}

	public class EditButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			edit();
		}

	}

}
