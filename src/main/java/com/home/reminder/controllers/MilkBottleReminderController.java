package com.home.reminder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.reminder.entities.MILK_BOTTLE_REMINDER;
import com.home.reminder.services.MilkBottleReminderService;

public class MilkBottleReminderController {

	@Autowired 
	private MilkBottleReminderService milBotRem;
	
	@RequestMapping(method=RequestMethod.POST, value="/bottleReminder")
	public void addReminder(@RequestBody MILK_BOTTLE_REMINDER reminder){
		milBotRem.addOneReminder(reminder);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="bottleReminder/{id}")
	public void deleteReminder(@PathVariable Integer id){
		milBotRem.deleteReminder(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "bottleReminder/{id}")
	public void updateReminder (@RequestBody MILK_BOTTLE_REMINDER reminder, @PathVariable Integer id){
		milBotRem.updateReminder(id, reminder);
	}
	
	@RequestMapping("bottleReminder/{id}")
	public MILK_BOTTLE_REMINDER getReminder(@PathVariable Integer id) {
		return milBotRem.getReminder(id).get();
	}
	
	@RequestMapping("/bottleReminder")
	public List<MILK_BOTTLE_REMINDER> getAllReminders(){
		return milBotRem.getAllReminders();
	}
	
	@RequestMapping("/bottleReminder/clear")
	public void deleteAllReminders(){
		 milBotRem.Clear();
	}
	
}
