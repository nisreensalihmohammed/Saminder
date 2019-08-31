package com.home.reminder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.reminder.entities.DIAPER_REMINDER;
import com.home.reminder.services.DiaperReminderService;

@RestController
public class DiaperReminderController {

	@Autowired 
	private DiaperReminderService dipRemServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/dipReminder")
	public void addReminder(@RequestBody DIAPER_REMINDER reminder){
		dipRemServ.addOneReminder(reminder);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="dipReminder/{id}")
	public void deleteReminder(@PathVariable Integer id){
		dipRemServ.deleteReminder(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "dipReminder/{id}")
	public void updateReminder (@RequestBody DIAPER_REMINDER reminder, @PathVariable Integer id){
		dipRemServ.updateReminder(id, reminder);
	}
	
	@RequestMapping("dipReminder/{id}")
	public DIAPER_REMINDER getReminder(@PathVariable Integer id) {
		return dipRemServ.getReminder(id).get();
	}
	
	@RequestMapping("/dipReminder")
	public List<DIAPER_REMINDER> getAllReminders(){
		return dipRemServ.getAllReminders();
	}
	
	@RequestMapping("/dipReminder/clear")
	public void deleteAllReminders(){
		 dipRemServ.Clear();
	}
	
}
