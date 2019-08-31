package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.repositories.appointmentReminderRepository;
import com.home.reminder.entities.APPOINTMENT_REMINDER;
@Service
public class AppointmentReminderService {

	@Autowired
	private appointmentReminderRepository appRemRep;
	
	public List<APPOINTMENT_REMINDER> getAllReminders(){ //Get all reminders
		
		List<APPOINTMENT_REMINDER> reminders = new ArrayList<>();
		appRemRep.findAll().forEach(reminders::add);
		return reminders;	
	}
	
	public Optional<APPOINTMENT_REMINDER> getReminder(Integer id) {        //*Get one reminder
		return   appRemRep.findById(id);
	}
	
	public void addOneReminder(APPOINTMENT_REMINDER reminder) {  //add one reminder
		appRemRep.save(reminder);
	}
	
	
	public void deleteReminder(Integer id) {  //delete one reminder
		appRemRep.deleteById(id);
	}
	
	public void Clear() {  //delete all reminders
		appRemRep.deleteAll();
	}
	
	public void updateReminder(Integer id, APPOINTMENT_REMINDER reminder) {  //update
	
		appRemRep.save(reminder);
	}
	
	
}
