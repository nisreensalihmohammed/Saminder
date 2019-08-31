package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.entities.APPOINTMENT;
import com.home.reminder.repositories.appointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private appointmentRepository appRep;
	
	public List<APPOINTMENT> getAllAppointments(){ //Get all appointments
		
		List<APPOINTMENT> appointments = new ArrayList<>();
		appRep.findAll().forEach(appointments::add);
		return appointments;	
	}
	
	public Optional<APPOINTMENT> getAppointment(Integer id) {        //*Get one appointment
		return   appRep.findById(id);
	}
	
	public void addOneAppointment(APPOINTMENT appointment) {  //add one appointment
		appRep.save(appointment);
	}
	
	
	public void deleteAppointment(Integer id) {  //delete one appointment
		appRep.deleteById(id);
	}
	
	public void Clear() {  //delete all appointments
		appRep.deleteAll();
	}
	
	public void updateAppointment(Integer id, APPOINTMENT appointment) {  //update
	
		appRep.save(appointment);
	}
	
	
}
