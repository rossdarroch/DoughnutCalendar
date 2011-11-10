package calendar_ex;
import java.util.ArrayList;
import java.util.List;


public class Appointment {

	private long ap_id; // unique id for the appointment
	
	public CalendarDate date;	//  date the appointment occurs - note ONLY ONE DATE
	public CalendarTime start_time, end_time; // start time and end time for the appointment
	
	public enum Recurrence{NONE, DAILY, WEEKLY, TWO_WEEKLY, FOUR_WEEKLY};
	
	public String description; // Description of the appointment
	public String location;    // where it occurs (optional)
	public String category;    // Type of appointment (eg, work, social, uni etc)
	public Recurrence recur;   // How often it recurs... see enum Recurrence
	public int reminder;		// Reminder n minutes before.
	
	
	public Appointment(CalendarDate the_date, CalendarTime s_time, CalendarTime e_time, String desc){
		ap_id = 0;
		
		date = the_date;
		start_time = s_time;
		
		end_time = e_time;
			

		description = desc;
		location = "";
		category = "";
		recur = Recurrence.NONE;
		reminder = 0;
	}
	
	public Appointment(CalendarDate the_date, CalendarTime s_time, CalendarTime e_time, String desc, String loc){
		ap_id = 0;

		date = the_date;
		start_time = s_time;
		
		end_time = e_time;
				
		description = desc;
		
		location = loc;
		category = "";
		recur = Recurrence.NONE;
		reminder = 0;
	}	
	
	public Appointment(CalendarDate the_date, CalendarTime s_time, CalendarTime e_time, String desc, String loc, String cat){
		ap_id = 0;

		date = the_date;
		start_time = s_time;
		
		end_time = e_time;

		description = desc;
		location = loc;
		category = cat;
		recur = Recurrence.NONE;
		reminder = 0;
	}
	
	public Appointment(CalendarDate the_date, CalendarTime s_time, CalendarTime e_time, String desc, String loc, String cat, Recurrence rec, int rem){
		ap_id = 0;

		date = the_date;
		start_time = s_time;
		
		end_time = e_time;
		
		description = desc;
		
		location = loc;
		category = cat;
		recur = rec;
		reminder = rem;
	}
		
	public static Appointment.Recurrence RecurrenceFromInt(int i){
		// helper function for reading recurrence from saved calendar file.
		
		switch (i){
			case 0: return Recurrence.NONE;
			case 1: return Recurrence.DAILY;
			case 2: return Recurrence.WEEKLY;
			case 3: return Recurrence.TWO_WEEKLY;
			case 4: return Recurrence.FOUR_WEEKLY;

			default: return Recurrence.NONE;
		
		}
		
	}
	
	public static int IntFromRecurrence(Appointment.Recurrence r){
		// helper function for reading recurrence from saved calendar file.
		
		switch (r){
			case NONE: return 0;
			case DAILY: return 1;
			case WEEKLY: return 2;
			case TWO_WEEKLY: return 3;
			case FOUR_WEEKLY: return 4;
			default: return 0;
		
		}
		
	}
	public void setID(long id_param){
		// set unique ID for the appointment
		ap_id = id_param;
	}
	
	public long getID(){
		// get unique ID for the appointment
		return ap_id;
	}

	public void printAppointment() {
		// print appointment to the console
		System.out.println(description);
		System.out.println(location);		
		System.out.println(category);
		System.out.println("Date: " + date.toString());
		System.out.println("Starts: " + start_time.toString());
		System.out.println("Ends: " + end_time.toString());
		System.out.println("Recurring: " + recur);		
		System.out.println("Reminder: " + reminder);
		
	}
	
	public String toString() {
		// print appointment to the console
		return(description+", "+location+", "+", "+category+", "+date.toString()+
			". Starts: "+start_time.toString()+". Ends: " + end_time.toString() + 
			", Recurring: " + recur + ", Reminder: " + reminder);
		
	}
	
	public List<CalendarDate> getRecurrenceDates(int startID, int endID){
		// given a start date ID and and end date id, returns a list of dates
		// that this appointment recurs. 
		
		List<CalendarDate> ids = new ArrayList<CalendarDate>();
		int id = CalendarDate.getDateID(date);
		
		// how many days between recurrences
		int gap = 0;
		
		// if the appointment date occurs within the time frame, keep this date
		if(id <= endID && id >= startID)
			ids.add(new CalendarDate(id));
		
		// get the gap between recurrences in days
		if(recur == Recurrence.NONE)
			return ids; // no recurrence so return
		else if(recur == Recurrence.DAILY)
			gap = 1;
		else if(recur == Recurrence.WEEKLY)
			gap = 7;
		else if(recur == Recurrence.TWO_WEEKLY)
			gap = 14;
		else if(recur == Recurrence.FOUR_WEEKLY)
			gap = 28;
		else
			gap = 9999;
		
		int i = 0;
		int cur_id = id+gap;
		
		// loop while cur date id <= end date id
		// increment by gap days
		while(cur_id <= endID){
			if(cur_id >=startID)
				ids.add(new CalendarDate(cur_id));
			cur_id +=gap;
		}
		
		return ids;
	}

	public List<CalendarDate> getRecurrenceDates(CalendarDate startDate, CalendarDate endDate) {
		// given a start date and and end date, returns a list of dates
		// that this appointment recurs. 
		
		CalendarDate.getDateID(date);
		
		return getRecurrenceDates(CalendarDate.getDateID(startDate), CalendarDate.getDateID(endDate));
	}
}
