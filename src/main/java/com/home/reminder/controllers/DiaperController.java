package com.home.reminder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.reminder.entities.DIAPER;
import com.home.reminder.services.DiaperService;

@RestController
public class DiaperController {

	@Autowired 
	private DiaperService dipServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/diaper")
	public void addDiaper(@RequestBody DIAPER diaper){
		dipServ.addOneDiaper(diaper);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="diaper/{id}")
	public void deleteDiaper(@PathVariable Integer id){
		dipServ.deleteDiaper(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "diaper/{id}")
	public void updateDiaper (@RequestBody DIAPER diaper, @PathVariable Integer id){
		dipServ.updateDiaper(id, diaper);
	}
	
	@RequestMapping("diaper/{id}")
	public DIAPER getDiaper(@PathVariable Integer id) {
		return dipServ.getDiaper(id).get();
	}
	
	@RequestMapping("/diaper")
	public List<DIAPER> getAllDiapers(){
		return dipServ.getAllDiapers();
	}
	
	@RequestMapping("/diaper/clear")
	public void deleteAllDiapers(){
		 dipServ.Clear();
	}
	
}
