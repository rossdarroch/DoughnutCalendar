import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public abstract class AppointmentHandler extends AndroidWindow {
	protected JTextArea eventField;
	protected Font font;
	protected JTextField fromField;
	protected Popup fromPopup;
	protected JTextField fromTimeField;
	protected Popup fromTimePopup;
	protected JTextField toField;
	protected Popup toPopup;
	protected JTextField toTimeField;
	protected Popup toTimePopup;
	protected JTextArea locationField;
	protected JPanel fieldsPanel;
	protected JPanel buttonsPanel;
	protected JButton backButton;
	protected JButton saveButton;
	protected JPanel buttonsWrapPanel;

	public void setup(JPanel panel) {

		fieldsPanel = new JPanel();
		// fieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		// fieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		// fieldsPanel.setPreferredSize(new Dimension(470, 500));

		JLabel eventLabel = new JLabel("Event");
		font = H.font();
		eventLabel.setFont(font);
		// eventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		eventField = new JTextArea(2, 12);
		eventField.setFont(font);
		eventField.setLineWrap(true);
		eventField.setWrapStyleWord(true);
		// eventField.setAlignmentX(Component.LEFT_ALIGNMENT);
		// eventField.setMaximumSize(eventField.getPreferredSize());
		JScrollPane eventFieldJSP = new JScrollPane(eventField);
		eventFieldJSP.setAlignmentX(Component.LEFT_ALIGNMENT);
		eventFieldJSP.setMaximumSize(eventFieldJSP.getPreferredSize());
		// fields.add(Box.createHorizontalGlue());
		fieldsPanel.add(eventLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		fieldsPanel.add(eventFieldJSP);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel fromLabel = new JLabel("From");
		fromLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fromLabel.setFont(font);
		fieldsPanel.add(fromLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		JPanel fromFieldsPanel = new JPanel();
		fromFieldsPanel.setLayout(new BoxLayout(fromFieldsPanel,
				BoxLayout.LINE_AXIS));
		fromField = new JTextField("15/11/2011");
		fromField.setFont(font);
		fromField.setMaximumSize(fromField.getPreferredSize());
		fromField.setEditable(false);
		fromField.setToolTipText("Click to edit");
		fromTimeField = new JTextField("09:00");
		fromTimeField.setFont(font);
		fromTimeField.setMaximumSize(fromTimeField.getPreferredSize());
		fromTimeField.setEditable(false);
		fromTimeField.setToolTipText("Click to edit");
		fromFieldsPanel.add(fromField);
		fromFieldsPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		fromFieldsPanel.add(fromTimeField);
		fromFieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(fromFieldsPanel);
		fieldsPanel.setFont(font);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel toLabel = new JLabel("To");
		toLabel.setFont(font);
		toLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(toLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		JPanel toFieldsPanel = new JPanel();
		toFieldsPanel.setLayout(new BoxLayout(toFieldsPanel,
				BoxLayout.LINE_AXIS));
		toField = new JTextField("15/11/2011");
		toField.setFont(font);
		toField.setMaximumSize(toField.getPreferredSize());
		toField.setEditable(false);
		toField.setToolTipText("Click to edit");
		toTimeField = new JTextField("10:00");
		toTimeField.setFont(font);
		toTimeField.setMaximumSize(toTimeField.getPreferredSize());
		toTimeField.setEditable(false);
		toTimeField.setToolTipText("Click to edit");
		toFieldsPanel.add(toField);
		toFieldsPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		toFieldsPanel.add(toTimeField);
		toFieldsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fieldsPanel.add(toFieldsPanel);

		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel locationLabel = new JLabel("Where");
		locationLabel.setFont(font);
		locationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		locationField = new JTextArea(2, 12);
		locationField.setFont(font);
		locationField.setLineWrap(true);
		locationField.setWrapStyleWord(true);
		JScrollPane locationFieldJSP = new JScrollPane(locationField);
		locationFieldJSP.setAlignmentX(Component.LEFT_ALIGNMENT);
		locationFieldJSP.setMaximumSize(locationFieldJSP.getPreferredSize());
		fieldsPanel.add(locationLabel);
		fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		fieldsPanel.add(locationFieldJSP);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(fieldsPanel);

		buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		// buttonsPanel.setLayout(new GridLayout(2, 2, 10, 10));
		saveButton = new JButton("Save");
		saveButton.setFont(font);
		backButton = new JButton("Back");
		backButton.setFont(font);
		// buttonsPanel.add(Box.createHorizontalGlue());
		buttonsPanel.add(saveButton);
		// buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		// JLabel emptyLabel = new JLabel("asdf");
		// buttonsPanel.add(emptyLabel);
		buttonsPanel.add(backButton);
		buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		buttonsPanel.setMaximumSize(buttonsPanel.getPreferredSize());

		// Panel for displaying the buttons on the right
		buttonsWrapPanel = new JPanel();
		buttonsWrapPanel.setLayout(new BoxLayout(buttonsWrapPanel,
				BoxLayout.LINE_AXIS));
		buttonsWrapPanel.add(Box.createHorizontalGlue());
		buttonsWrapPanel.add(buttonsPanel);
		buttonsWrapPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(buttonsWrapPanel);
		
	}

}
