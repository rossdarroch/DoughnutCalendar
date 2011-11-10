package calendar_ex;

public class CalendarTime {
	
	// time object designed to work with the calendar class
	
	public int hr; // hour and minute for the time
	public int min;
	
	public CalendarTime(int the_hr, int the_min){
		hr = the_hr;
		min = the_min;
	}
	
	public static CalendarTime GetDuration(CalendarTime start_time, CalendarTime end_time){
		// given the start and end of the meeting, get the duration.
		
		int start_mins = 60 * start_time.hr + start_time.min;
		int end_mins = 60 * end_time.hr + end_time.min;
		
		int diff = end_mins - start_mins;
		
		return new CalendarTime(diff%60, diff / 60);
		
	}

	public String toString() {
		// turn the time into a string
		
		return "" + hr + ":" + min;
	}
}
