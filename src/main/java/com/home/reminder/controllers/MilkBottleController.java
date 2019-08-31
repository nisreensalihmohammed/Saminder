package com.home.reminder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.reminder.entities.MILK_BOTTLE;
import com.home.reminder.services.MilkBottleService;

@RestController
public class MilkBottleController {

	@Autowired 
	private MilkBottleService milBotServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/bottle")
	public void addBottle(@RequestBody MILK_BOTTLE bottle){
		milBotServ.addOneBottle(bottle);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="bottle/{id}")
	public void deleteBottle(@PathVariable Integer id){
		milBotServ.deleteBottle(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "bottle/{id}")
	public void updateReminder (@RequestBody MILK_BOTTLE bottle, @PathVariable Integer id){
		milBotServ.updateBottles(id, bottle);
	}
	
	@RequestMapping("bottle/{id}")
	public MILK_BOTTLE getBottle(@PathVariable Integer id) {
		return milBotServ.getBottle(id).get();
	}
	
	@RequestMapping("/bottle")
	public List<MILK_BOTTLE> getAllBottles(){
		return milBotServ.getAllBottles();
	}
	
	@RequestMapping("/bottle/clear")
	public void deleteAllBottles(){
		 milBotServ.Clear();
	}
	
}
