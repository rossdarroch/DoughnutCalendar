
import java.util.Calendar;
import java.util.GregorianCalendar;

import calendar_ex.CalendarDate;


public class Context {
	private CalendarDate clock_date; // real world clock
	private CalendarDate view_date; // the date we are viewing
	
	private static Context c;
	
	public static Context getContext() {
		if(c == null)
			c = new Context();
		return c;
	}

	public CalendarDate getViewDate() {
		return view_date;
	}

	public void setViewDate(CalendarDate view_date) {
		this.view_date = view_date;
	}

	public CalendarDate getCurrentDate() {
		return clock_date;
	}

	public void setCurrentDate(CalendarDate current_date) {
		this.clock_date = current_date;
	}
	
	Context() {
		Calendar now = new GregorianCalendar();
		int d = now.get(Calendar.DAY_OF_MONTH);
		int m = now.get(Calendar.MONTH);
		int y = now.get(Calendar.YEAR);
		view_date = new CalendarDate(d,	m, y);
		clock_date = new CalendarDate(d, m, y);
		
	}
	
}
