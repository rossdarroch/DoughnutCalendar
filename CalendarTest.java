

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calendar_ex.*;
import calendar_ex.Appointment.Recurrence;
import javax.swing.Box;
import javax.swing.Box.Filler;

public class CalendarTest extends JFrame implements ActionListener, WindowListener{

	private final String NEXT_COMMAND = "NEXT";
	private final String PREV_COMMAND = "PREV";
	
	CalendarEx cal;
	JTextField start_day_tf, end_day_tf, start_month_tf, end_month_tf,
		start_year_tf, end_year_tf, id_tf;
	
	JTextField id, date, month, year, start_time, end_time, recurs, description, location, category, reminder;

	List<Appointment> aps;
	ListIterator<Appointment> aps_it;
	Appointment cur_ap;
	JButton but, add_but, del_but;
	
	public CalendarTest(){

		cal = new CalendarEx();
		
		cal.openCalendar("./calendar.txt");	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel start_l = new JLabel("Enter Start Date");
		JLabel end_l = new JLabel("Enter End Date");

		addWindowListener(this);
		start_day_tf = new JTextField("1", 5);
		end_day_tf = new JTextField("11", 5);
		start_month_tf = new JTextField("1", 5);
		end_month_tf = new JTextField("11", 5);
		start_year_tf = new JTextField("2009", 5);
		end_year_tf = new JTextField("2009", 5);
		
		id_tf = new JTextField("0", 3);
		
		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.X_AXIS));
		//startPanel.setPreferredSize(new Dimension(200, 200));
		startPanel.add(start_l);//, BorderLayout.NORTH);
		startPanel.add(start_day_tf);//, BorderLayout.WEST);
		startPanel.add(start_month_tf);//, BorderLayout.CENTER);
		startPanel.add(start_year_tf);//, BorderLayout.EAST);
		startPanel.add(id_tf);//, BorderLayout.SOUTH);
		
		JPanel endPanel = new JPanel();
		endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.X_AXIS));
		//endPanel.setPreferredSize(new Dimension(200, 200));
		endPanel.add(end_l);//, BorderLayout.NORTH);
		endPanel.add(end_day_tf);//, BorderLayout.WEST);
		endPanel.add(end_month_tf);//, BorderLayout.CENTER);
		endPanel.add(end_year_tf);//, BorderLayout.EAST);
		
		JPanel search_pan = new JPanel();//= this.getContentPane();
		search_pan.setLayout(new BoxLayout(search_pan, BoxLayout.Y_AXIS));

		
		but = new JButton("Find Appointments");
		add_but = new JButton("Add Appointment");
		del_but = new JButton("Delete Appointment");
		
		JPanel but_pan = new JPanel();
		but_pan.setLayout(new BorderLayout());
		
		but.addActionListener(this);
		add_but.addActionListener(this);
		del_but.addActionListener(this);

		but_pan.add(but, BorderLayout.NORTH);
		but_pan.add(add_but, BorderLayout.CENTER);
		but_pan.add(del_but, BorderLayout.SOUTH);
		
		search_pan.add(startPanel);
		search_pan.add(endPanel);
		search_pan.add(but_pan);
		
		AppointmentPanel ap = new AppointmentPanel();
		
		Container pan = this.getContentPane();
		pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));
		pan.add(search_pan);
		pan.add(ap);
		
		pack();
		setVisible(true);
		
	}
	
	class AppointmentPanel extends JPanel{
		
		
		//JTextField id, date, month, year, start_time, end_time, recurs, description, location, category, reminder;
		
		public AppointmentPanel(){
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
			id = new JTextField(4);
			
			JPanel datePanel = new JPanel();
			datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
			date = new JTextField(2);
			month = new JTextField(2);
			year = new JTextField(4);
			datePanel.add(date);
			datePanel.add(month);
			datePanel.add(year);
			
			JPanel timePanel = new JPanel();
			timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
			start_time = new JTextField(6);
			end_time = new JTextField(6);
			timePanel.add(start_time);
			timePanel.add(new Filler(new Dimension(5, 5), new Dimension(5, 5), new Dimension(5, 5)));
			timePanel.add(end_time);
			
			recurs = new JTextField(10);
			description = new JTextField(20);
			location = new JTextField(20);
			category = new JTextField(20);
			reminder = new JTextField(10);

			JPanel button_panel = new JPanel();
			JButton bprev, bnext;
			bprev = new JButton("Previous");
			bprev.setActionCommand(PREV_COMMAND);
			bnext = new JButton("Next");
			bnext.setActionCommand(NEXT_COMMAND);
			bprev.addActionListener(new NavigationActionListener());
			bnext.addActionListener(new NavigationActionListener());
			
			button_panel.add(bprev);
			button_panel.add(bnext);

			add(id);
			add(description);
			add(location);
			add(datePanel);
			add(timePanel);
			add(category);
			add(recurs);
			add(reminder);
			add(button_panel);
		}
	}
	
	class NavigationActionListener implements ActionListener{
		
		public NavigationActionListener(){
			
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			if(ae.getActionCommand() == PREV_COMMAND)
				if(aps_it != null)
					if(aps_it.hasPrevious()){
						cur_ap = aps_it.previous();
						SetAppointment(cur_ap);
					}
					else
						System.out.println("No Previous");
				else
					System.out.println("aps_it is null");


			else if(ae.getActionCommand() == NEXT_COMMAND)
				if(aps_it != null)
					if(aps_it.hasNext()){
						cur_ap = aps_it.next();
						SetAppointment(cur_ap);
					}
					else
						System.out.println("No Next");
				else
					System.out.println("aps_it is null");
		}
		

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
//		
		CalendarTest ct = new CalendarTest();
		

		//cal.printCalendar();
		
		
//		
//		CalendarDate cd;
//		for(int i = 0; i < 730; i++){
//			cd = CalendarDate.getDateFromID(i);
//			System.out.println("" + i + ", " +cd.day + ", " + cd.month + ", " + cd.year);
//		}
			
			
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == but){
			int start_day, end_day, start_month, end_month, start_year, end_year;
			
			start_day = Integer.parseInt(start_day_tf.getText());
			end_day = Integer.parseInt(end_day_tf.getText());
			start_month = Integer.parseInt(start_month_tf.getText());
			end_month = Integer.parseInt(end_month_tf.getText());
			start_year = Integer.parseInt(start_year_tf.getText());
			end_year = Integer.parseInt(end_year_tf.getText());
			
			System.out.println("Appointments between " + start_day+"/"+start_month+"/"+start_year+
					" and " + end_day +"/"+"end_month" + "/" + end_year+"\n");
			
			CalendarDate start_date = new CalendarDate(start_day,start_month,start_year);
			CalendarDate end_date = new CalendarDate(end_day,end_month,end_year);
			
			aps = cal.getAppointmentsBetweenDates(start_date, end_date);
	
			//Appointment ap;
			List<CalendarDate> rd;
			ListIterator<CalendarDate> it_rec;
			//ListIterator<Appointment> it = aps.listIterator();
			aps_it = aps.listIterator();
			
			if(aps_it.hasNext())
				cur_ap = aps_it.next();
			else
				System.out.println("No Next");
			
			SetAppointment(cur_ap);
			
			CalendarDate cd;
////			while(it.hasNext()){
//				ap = it.next();
//				
//				ap.printAppointment();
//				System.out.println("Recurs: ");
//				rd = ap.getRecurrenceDates(start_date, end_date);
//				
//				if(rd != null){
//					it_rec = rd.listIterator();
//					while(it_rec.hasNext()){
//						cd = it_rec.next();
//						System.out.print(cd.Stringify() + ", ");
//					}
//				}
//				System.out.println("");
//			}
		}
		else if(ae.getSource() == add_but){
			CalendarDate cd = new CalendarDate(Integer.parseInt(date.getText()),
					Integer.parseInt(month.getText()),
					Integer.parseInt(year.getText()));
			CalendarTime st = new CalendarTime(9, 0);
			CalendarTime et = new CalendarTime(10, 0);
			Appointment ap = new Appointment(cd, st, et, description.getText(), location.getText(), category.getText(), Appointment.Recurrence.NONE, Integer.parseInt(reminder.getText()));
			
			cal.addAppointment(ap);
			System.out.println(ap.getID());
		}
		else if(ae.getSource() == del_but){
			int id = Integer.parseInt(id_tf.getText());
			
			Appointment ap = cal.getAppointmentByID(id);
			if(ap != null)
				cal.removeAppointment(ap);
		}
		

		
	}
	private void SetAppointment(Appointment curAp) {

		id.setText(""+curAp.getID());
		date.setText(""+curAp.date.day);
		month.setText(""+curAp.date.month);
		year.setText(""+curAp.date.year);
		start_time.setText(curAp.start_time.hr + ":"+curAp.start_time.min);
		end_time.setText(curAp.end_time.hr + ":"+curAp.end_time.min);
		recurs.setText(""+curAp.recur);
		description.setText(curAp.description);
		location.setText(curAp.location);
		category.setText(curAp.category);
		reminder.setText(""+curAp.reminder);

		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("Saving");
		cal.saveCalendar("./calendar.txt");
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
