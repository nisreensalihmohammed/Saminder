package com.home.reminder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.reminder.entities.APPOINTMENT;
import com.home.reminder.services.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired 
	private AppointmentService appServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/appointment")
	public void addAppointment(@RequestBody APPOINTMENT appoint){
		appServ.addOneAppointment(appoint);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="appointment/{id}")
	public void deleteAppointment(@PathVariable Integer id){
		appServ.deleteAppointment(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "appointment/{id}")
	public void updateAppointment (@RequestBody APPOINTMENT appoint, @PathVariable Integer id){
		appServ.updateAppointment(id, appoint);
	}
	
	@RequestMapping("appointment/{id}")
	public APPOINTMENT getReminder(@PathVariable Integer id) {
		return appServ.getAppointment(id).get();
	}
	
	@RequestMapping("/appointment")
	public List<APPOINTMENT> getAllAppointments(){
		return appServ.getAllAppointments();
	}
	
	@RequestMapping("/appointment/clear")
	public void deleteAllAppointments(){
		 appServ.Clear();
	}
	
}
