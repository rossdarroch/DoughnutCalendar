import calendar_ex.CalendarDate;


public class Context {
	CalendarDate clock_date; // real world clock
	CalendarDate view_date; // the date we are viewing
	
	
	public static Context getContext() {
		return null;
	}

	public CalendarDate getView_date() {
		return view_date;
	}

	public void setView_date(CalendarDate view_date) {
		this.view_date = view_date;
	}

	public CalendarDate getCurrent_date() {
		return clock_date;
	}

	public void setCurrent_date(CalendarDate current_date) {
		this.clock_date = current_date;
	}

	public Context(CalendarDate current_date) {
		super();
		this.clock_date = current_date;
	}
}
