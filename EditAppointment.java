
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditAppointment extends AppointmentHandler {

	private JButton editButton;
	private JButton deleteButton;

	@Override
	public void setup(Container panel) {
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
	}

}
