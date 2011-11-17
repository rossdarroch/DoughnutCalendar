import java.awt.*;

import javax.swing.*;

public class CreateAppointment extends AndroidWindow {

	@Override
	public void setup(Container panel) {

		JPanel fieldsPanel = new JPanel();
		// fieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		// fieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		// fieldsPanel.setPreferredSize(new Dimension(470, 500));

		JLabel eventLabel = new JLabel("Event");
		Font font = new Font(eventLabel.getFont().getFontName(),
				eventLabel.getFont().getStyle(), 3 * eventLabel.getFont()
						.getSize());
		eventLabel.setFont(font);
		// eventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JTextArea eventField = new JTextArea(2, 12);
		eventField.setFont(font);
		eventField.setAlignmentX(Component.LEFT_ALIGNMENT);
		eventField.setMaximumSize(eventField.getPreferredSize());
		// fields.add(Box.createHorizontalGlue());
		fieldsPanel.add(eventLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		fieldsPanel.add(eventField);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel fromLabel = new JLabel("From");
		fromLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fromLabel.setFont(font);
		fieldsPanel.add(fromLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		JPanel fromFieldsPanel = new JPanel();
		fromFieldsPanel.setLayout(new BoxLayout(fromFieldsPanel,
				BoxLayout.LINE_AXIS));
		JTextField fromField = new JTextField("15/11/2011");
//		fromField.setFont(font);
		fromField.setMaximumSize(fromField.getPreferredSize());
		JTextField fromTimeField = new JTextField("09:00");
//		fromTimeField.setFont(font);
		fromTimeField.setMaximumSize(fromTimeField.getPreferredSize());
		fromFieldsPanel.add(fromField);
		fromFieldsPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		fromFieldsPanel.add(fromTimeField);
		fromFieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(fromFieldsPanel);
fieldsPanel.setFont(font);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel toLabel = new JLabel("To");
//		toLabel.setFont(font);
		toLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(toLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		JPanel toFieldsPanel = new JPanel();
		toFieldsPanel.setLayout(new BoxLayout(toFieldsPanel,
				BoxLayout.LINE_AXIS));
		JTextField toField = new JTextField("15/11/2011");
		toField.setFont(font);
		toField.setMaximumSize(toField.getPreferredSize());
		JTextField toTimeField = new JTextField("10:00");
		toTimeField.setFont(font);
		toTimeField.setMaximumSize(toTimeField.getPreferredSize());
		toFieldsPanel.add(toField);
		toFieldsPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		toFieldsPanel.add(toTimeField);
		toFieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(toFieldsPanel);

		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel locationLabel = new JLabel("Where");
		locationLabel.setFont(font);
		locationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JTextArea locationField = new JTextArea(2, 12);
		locationField.setFont(font);
		locationField.setAlignmentX(Component.LEFT_ALIGNMENT);
		locationField.setMaximumSize(locationField.getPreferredSize());
		fieldsPanel.add(locationLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		fieldsPanel.add(locationField);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel
				.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
		JButton saveButton = new JButton("Save");
		saveButton.setFont(font);
		JButton back = new JButton("Back");
		back.setFont(font);
		buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(saveButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonsPanel.add(back);
		buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(fieldsPanel);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(buttonsPanel);

	}
}