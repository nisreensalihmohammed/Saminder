package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.entities.MILK_BOTTLE;
import com.home.reminder.repositories.milkBottleRepository;

@Service
public class MilkBottleService {

	@Autowired
	private milkBottleRepository  milkRep;
	
	public List<MILK_BOTTLE> getAllBottles(){ //Get all bottles
		
		List<MILK_BOTTLE> bottle = new ArrayList<>();
		 milkRep.findAll().forEach(bottle::add);
		return bottle;	
	}
	
	public Optional<MILK_BOTTLE> getBottle(Integer id) {        //*Get one bottle
		return    milkRep.findById(id);
	}
	
	public void addOneBottle(MILK_BOTTLE bottle) {  //add one bottle
		 milkRep.save(bottle);
	}
	
	
	public void deleteBottle(Integer id) {  //delete one bottle
		 milkRep.deleteById(id);
	}
	
	public void Clear() {  //delete all bottles
		 milkRep.deleteAll();
	}
	
	public void updateBottles(Integer id, MILK_BOTTLE bottle) {  //update
	
		 milkRep.save(bottle);
	}
	
}
