package calendar_ex;

import java.io.PrintStream;
import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CalendarEx {

	// Calendar object contains a list of appointments
	List<Appointment> appList;          // List implemented as growable array
	long max_id = 0; // maximum appointment id in the calendar. Used 
					 // when adding a new appointment
	
	 public CalendarEx()
	    {
		 
		 appList = new ArrayList<Appointment>();
		 
		 return;
	 }
	
	 public boolean openCalendar(String fileName){
		 // given the file name of a stored calendar, loads the appointments list
		 
		   BufferedReader bis = null;

		   Appointment ap;
		   try {

		     // Here BufferedInputStream is added for fast reading.
		     // open file
			 bis = new BufferedReader(new FileReader(fileName));

		     // dis.available() returns 0 if the file does not have more lines.

		     String s;
		     s = bis.readLine();
		     int start_date, end_date, id;
		     int start_time_h, start_time_m, end_time_h, end_time_m;
		     
		     String description, location, category;
		     int recurrence, reminder;
		     
		     while (s != null) {
		    	 
		    	 // read appointments until we run out of file
		    	 id = Integer.parseInt(bis.readLine());		    	 

		    	 // update the max_id found in the calendar
		    	 if(id > max_id)
		    		 max_id = id;
		    	 
		    	 start_date = Integer.parseInt(bis.readLine());		    	 
			     start_time_h = Integer.parseInt(bis.readLine());
			     start_time_m = Integer.parseInt(bis.readLine());
			     
			     end_date = Integer.parseInt(bis.readLine());
			     end_time_h = Integer.parseInt(bis.readLine());
			     end_time_m = Integer.parseInt(bis.readLine());
			     
			     description = bis.readLine();
			     location = bis.readLine();
			     category = bis.readLine();
			     
			     recurrence = Integer.parseInt(bis.readLine());
			     reminder = Integer.parseInt(bis.readLine());
			     
			     // create the appointment object
			     ap = new Appointment(new CalendarDate(start_date), 
			    		 			  new CalendarTime(start_time_h, start_time_m),
			    		 			  new CalendarDate(end_date),
			    		 			  new CalendarTime(end_time_h, end_time_m),
			    		 			  description,
			    		 			  location,
			    		 			  category,
			    		 			  Appointment.RecurrenceFromInt(recurrence),
			    		 			  reminder);
			     
			     ap.setID(id);
			     
			     // add appointment to the appointments list
			     appList.add(ap);
			   
			     // read through separators
			     s = bis.readLine();
			     s = bis.readLine();
			     
			     //ap.printAppointment();
		      }

		      // dispose all the resources after using them.
		      bis.close();
		      
		      return true;


		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		 
		 return false;
	 }

	 public boolean saveCalendar(String fileName) {
		  // saves the calendar to the file of given file name.
		 FileOutputStream out;
		 PrintStream p;
		 
		 try{
			 out = new FileOutputStream(fileName);
			 p = new PrintStream(out);
			 

			 Appointment ap;
			 ListIterator<Appointment> it = appList.listIterator();
			 
			 while(it.hasNext())
			 {
				 ap = (Appointment) it.next();
				 
				 p.println("<");				 
				 p.println(ap.getID());
				 p.println(CalendarDate.getDateID(ap.start_date));
				 p.println(ap.start_time.hr);
				 p.println(ap.start_time.min);

				 p.println(CalendarDate.getDateID(ap.end_date));
				 p.println(ap.end_time.hr);
				 p.println(ap.end_time.min);
				 
				 p.println(ap.description);
				 p.println(ap.location);
				 p.println(ap.category);

				 p.println(Appointment.IntFromRecurrence(ap.recur));
				 p.println(ap.reminder);
			     
				 p.println(">");
				 
				 //ap.printAppointment();
				 //System.out.println("\n");
			 }
			 
		 } catch (Exception e) { 
				System.err.println ("Error writing to file"); 
				return false;
		 } 		 
	  return true;
	 }

	 
	 public void printCalendar() {
	  
		 // prints all appointments in the calendar to the console
		 Appointment ap;
		 ListIterator<Appointment> it = appList.listIterator();
		 
		 while(it.hasNext())
		 {
			 ap = (Appointment) it.next();
			 ap.printAppointment();
			 System.out.println("\n");
		 }
		 
	  return;
	 }
	  

	 public void addAppointment(Appointment ap){
		 // add an appointment to the calendar
		 max_id++;
		 ap.setID(max_id);
		 
		 appList.add(ap);
		 
	 }
	 
	 public List<Appointment> getAppointmentsBetweenDates(CalendarDate start, CalendarDate end){

		 // given a start and end date, returns a list of appointments that recur between these dates
		 
		 int startID = CalendarDate.getDateID(start);
		 int endID = CalendarDate.getDateID(end);
		 
		 List<Appointment> aps = new ArrayList<Appointment>();

		 Appointment ap;
		 ListIterator<Appointment> it = appList.listIterator();
		 
		 int ap_ID;

		 while(it.hasNext())
		 {
			 ap = (Appointment) it.next();
			 
			 List <CalendarDate> cd =  ap.getRecurrenceDates(startID, endID);

			 if(cd.size() > 0){
				 aps.add(ap);
			 }
		 }
		 
		 return aps;
		 
	 }
	
	 public boolean removeAppointment(Appointment ap){
		 // remove the appointment from the calendar list.
		 return appList.remove(ap);
		 
	 }
	 public Appointment getAppointmentByID(int ID){
		 // given appointemnt ID number, returns the Appointment
		 ListIterator<Appointment> aps = appList.listIterator();
		 
		 Appointment ap;
		 while(aps.hasNext()){
			 ap = aps.next();
			 if(ap.getID() == ID)
				 return ap;
		 }
		 
		 return null;
	 }
	
	
}
