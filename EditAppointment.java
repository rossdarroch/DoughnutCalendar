<<<<<<< HEAD
import java.awt.Container;
=======

>>>>>>> branch 'master' of https://jeopard@github.com/DangerousDoughnuts/DoughnutCalendar.git
import java.awt.GridLayout;
import java.util.TimeZone;

import javax.swing.JButton;
<<<<<<< HEAD
import javax.swing.JComboBox;
import javax.swing.JLabel;
=======
import javax.swing.JPanel;
>>>>>>> branch 'master' of https://jeopard@github.com/DangerousDoughnuts/DoughnutCalendar.git

public class EditAppointment extends AppointmentHandler {

	private JButton editButton;
	private JButton deleteButton;

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
		
//		JPanel extraButtonsPanel = new JPanel();
//		extraButtonsPanel.setLayout(new BoxLayout(extraButtonsPanel, BoxLayout.LINE_AXIS));
//		extraButtonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		editButton = new JButton("Edit");
		editButton.setFont(font);
		deleteButton = new JButton("Delete");
		deleteButton.setFont(font);
//		buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(editButton);
//		extraButtonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonsPanel.add(deleteButton);
//		buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

//		panel.add(Box.createRigidArea(new Dimension(0, 10)));
//		panel.add(extraButtonsPanel);
		buttonsPanel.setMaximumSize(buttonsPanel.getPreferredSize());
		
		JLabel timeZoneLabel = new JLabel("Time Zone");
		TimeZone timeZone = TimeZone.getDefault();
		JLabel test = new JLabel(timeZone.getDisplayName());
		panel.add(test);
		String timeZones[] = new String[TimeZone.getAvailableIDs().length];
//		for (int i = 0; i < timeZoneIDs.length; i++)
//			
//		JComboBox timeZoneField = new JComboBox(TimeZone.getAvailableIDs());
//		panel.add(timeZoneField);
		
		
		
		
		
		
		
		
		
		
		
	}

}
