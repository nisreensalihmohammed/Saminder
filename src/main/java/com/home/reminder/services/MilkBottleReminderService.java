package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.entities.MILK_BOTTLE_REMINDER;
import com.home.reminder.repositories.milkBottleReminderRepository;

@Service
public class MilkBottleReminderService {

	@Autowired
	private milkBottleReminderRepository milkRemRep;
	
	public List<MILK_BOTTLE_REMINDER> getAllReminders(){ //Get all reminders
		
		List<MILK_BOTTLE_REMINDER> reminders = new ArrayList<>();
		milkRemRep.findAll().forEach(reminders::add);
		return reminders;	
	}
	
	public Optional<MILK_BOTTLE_REMINDER> getReminder(Integer id) {        //*Get one reminder
		return   milkRemRep.findById(id);
	}
	
	public void addOneReminder(MILK_BOTTLE_REMINDER reminder) {  //add one reminder
		milkRemRep.save(reminder);
	}
	
	
	public void deleteReminder(Integer id) {  //delete one reminder
		milkRemRep.deleteById(id);
	}
	
	public void Clear() {  //delete all reminders
		milkRemRep.deleteAll();
	}
	
	public void updateReminder(Integer id, MILK_BOTTLE_REMINDER reminder) {  //update
	
		milkRemRep.save(reminder);
	}
	
}
