package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.entities.DIAPER_REMINDER;
import com.home.reminder.repositories.diaperReminderRepository;

@Service
public class DiaperReminderService {

	@Autowired
	private diaperReminderRepository dipRemRep;
	
	public List<DIAPER_REMINDER> getAllReminders(){ //Get all reminders
		
		List<DIAPER_REMINDER> reminders = new ArrayList<>();
		dipRemRep.findAll().forEach(reminders::add);
		return reminders;	
	}
	
	public Optional<DIAPER_REMINDER> getReminder(Integer id) {        //*Get one reminder
		return   dipRemRep.findById(id);
	}
	
	public void addOneReminder(DIAPER_REMINDER reminder) {  //add one reminder
		dipRemRep.save(reminder);
	}
	
	
	public void deleteReminder(Integer id) {  //delete one reminder
		dipRemRep.deleteById(id);
	}
	
	public void Clear() {  //delete all reminders
		dipRemRep.deleteAll();
	}
	
	public void updateReminder(Integer id, DIAPER_REMINDER reminder) {  //update
	
		dipRemRep.save(reminder);
	}
	
	
}
