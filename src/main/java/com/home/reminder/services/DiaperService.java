package com.home.reminder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.reminder.entities.DIAPER;
import com.home.reminder.repositories.diaperRepository;

@Service
public class DiaperService {

	@Autowired
	private diaperRepository dipRep;
	
	public List<DIAPER> getAllDiapers(){ //Get all diapers
		
		List<DIAPER>  diapers = new ArrayList<>();
		dipRep.findAll().forEach( diapers::add);
		return  diapers;	
	}
	
	public Optional<DIAPER> getDiaper(Integer id) {        //*Get one diaper
		return   dipRep.findById(id);
	}
	
	public void addOneDiaper(DIAPER diaper) {  //add one diaper
		dipRep.save(diaper);
	}
	
	
	public void deleteDiaper(Integer id) {  //delete one diaper
		dipRep.deleteById(id);
	}
	
	public void Clear() {  //delete all diapers
		dipRep.deleteAll();
	}
	
	public void updateDiaper(Integer id, DIAPER diaper) {  //update
	
		dipRep.save(diaper);
	}
	
	
}
