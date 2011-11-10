package calendar_ex;

public class CalendarDate {
	
	// class to store a date for use with the calendar
	// NOTE: Only accurate until the next leap year.
	
	// constants to provide an initial day for the date id
	private static int FIRST_DAY = 1, FIRST_MONTH = 1, FIRST_YEAR = 2009;
	
	// day, month and year of the Date
	public int day, month, year;
	
	// unique id given from the date. Counting from FIRST_DAY, FIRST_MONTH, FIRST_YEAR
	int dateID;
	
	public CalendarDate(int the_day, int the_month, int the_year){
		day = the_day;
		month = the_month;
		year = the_year;
		
		dateID = getDateID(day, month, year);
	}

	public CalendarDate(int id){
		
		CalendarDate cd  = getDateFromID(id);
		day = cd.day;
		month = cd.month;
		year = cd.year;
		
		dateID = id;
	}

	public static int getDateID(CalendarDate cd){
		// from the date, get the appropriate date ID
		return getDateID(cd.day, cd.month, cd.year);
	}

	public static int getDateID(int d, int m, int y){
		// get the date ID from the day, month and year
		
		if(d>31 || d<1 || m>12 || m<1 || y < FIRST_YEAR)
			return -1;
		
		int no_years = y - FIRST_YEAR;
		int no_months = m - FIRST_MONTH;
		int no_days = d - FIRST_DAY;
		
		int y_val = no_years * 365;
		int m_val = 0;
		
		switch (no_months){
			case 0: m_val = 0; break;
			case 1: m_val = 31;break;
			case 2: m_val = 59;break;
			case 3: m_val = 90;break;
			case 4: m_val = 120;break;
			case 5: m_val = 151;break;
			case 6: m_val = 181;break;
			case 7: m_val = 212;break;
			case 8: m_val = 243;break;
			case 9: m_val = 273;break;
			case 10: m_val = 304;break;
			case 11: m_val = 334;break;

			default: return -1;
		
		}

		int d_val = no_days;
		
		return y_val + m_val + d_val;
	}

	public static CalendarDate getDateFromID(int id){
		// given a date id, get the relevant calendar date
		if(id < 0)
			return null;
		
		int no_years = id / 365;
		int no_months =0;
		int no_days = 0;
		
		int rem_month_id = id - (no_years* 365);
		
		if(rem_month_id < 31){
			no_months = 1;
			no_days = 1 + rem_month_id;
		}
		else if(rem_month_id < 59){
			no_months = 2;
			no_days = rem_month_id-30;			
		}
		else if(rem_month_id < 90){
			no_months = 3;
			no_days = rem_month_id-58;			
		}
		else if(rem_month_id < 120){
			no_months = 4;
			no_days = rem_month_id-89;			
		}
		else if(rem_month_id < 151){
			no_months = 5;
			no_days = rem_month_id-119;			
		}			
		else if(rem_month_id < 181){
			no_months = 6;
			no_days = rem_month_id-150;			
		}
		else if(rem_month_id < 181){
			no_months = 6;
			no_days = rem_month_id-150;			
		}
		else if(rem_month_id < 212){
			no_months = 7;
			no_days = rem_month_id-180;			
		}
		else if(rem_month_id < 243){
			no_months = 8;
			no_days = rem_month_id-211;			
		}
		else if(rem_month_id < 273){
			no_months = 9;
			no_days = rem_month_id-242;			
		}
		else if(rem_month_id < 304){
			no_months = 10;
			no_days = rem_month_id-272;			
		}
		else if(rem_month_id < 334){
			no_months = 11;
			no_days = rem_month_id-303;			
		}
		else{
			no_months = 12;
			no_days = rem_month_id-333;			
		}		
	
		return new CalendarDate(no_days, no_months, no_years+FIRST_YEAR);
		
	}
	
	public static String getDay(int d, int m, int y){
		// Given the date, get the day
		
		int the_id = getDateID(d, m, y);
		
		switch (the_id % 7){
			case 0 : return "THURSDAY";
			case 1 : return "FRIDAY";
			case 2 : return "SATURDAY";
			case 3 : return "SUNDAY";
			case 4 : return "MONDAY";
			case 5 : return "TUESDAY";
			case 6 : return "WEDNESDAY";
			default: return "ANYDAY";
		}
	}

	public String toString() {
		// turn the CalendarDate object into a string
		
		return "" + day + "-"+month+"-"+year;
		
	}
}
