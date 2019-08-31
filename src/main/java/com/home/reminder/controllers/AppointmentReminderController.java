package com.home.reminder.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.reminder.entities.APPOINTMENT_REMINDER;
import com.home.reminder.services.AppointmentReminderService;



@RestController
public class AppointmentReminderController {

	@Autowired 
	private AppointmentReminderService remServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/appoReminder")
	public void addReminder(@RequestBody APPOINTMENT_REMINDER reminder){
		remServ.addOneReminder(reminder);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="appoReminder/{id}")
	public void deleteReminder(@PathVariable Integer id){
		remServ.deleteReminder(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "appoReminder/{id}")
	public void updateReminder (@RequestBody APPOINTMENT_REMINDER reminder, @PathVariable Integer id){
		remServ.updateReminder(id, reminder);
	}
	
	@RequestMapping("appoReminder/{id}")
	public APPOINTMENT_REMINDER getReminder(@PathVariable Integer id) {
		return remServ.getReminder(id).get();
	}
	
	@RequestMapping("/appoReminder")
	public List<APPOINTMENT_REMINDER> getAllReminders(){
		return remServ.getAllReminders();
	}
	
	@RequestMapping("/appoReminder/clear")
	public void deleteAllReminders(){
		 remServ.Clear();
	}
	
}
