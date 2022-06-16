package com.chainsys.springproject.beans;
   // Multiply factory methods in one class.
   //Calendar factory is also called initiating bean because methods in this bean instantiates object for other beans
public class CalendarFactory {
	// The factory method is not static 
    public Calendar createCalendar()  {
    	// the Calendar constructor is default access modifier so, can be called here.
    	// The Calendar class and the Calendar factoryClass are both in the same package
    	return new Calendar();
    }
    public Appointments createAppointment() {
    	return new Appointments();
    }
}
