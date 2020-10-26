package com.aircraft.acservice.service;

import java.util.TreeSet;
import org.springframework.stereotype.Service;
import com.aircraft.acservice.model.Aircraft;
import com.aircraft.acservice.utils.AircraftComperator;

@Service
public class AircraftService {
	
	private static TreeSet<Aircraft> aircrafts = new TreeSet<Aircraft>(new AircraftComperator());
	
	public TreeSet<Aircraft> getAllAircrafts() {
		return aircrafts;
	}	
	
	public void add(Aircraft craft) {
		aircrafts.add(craft);
	}
	
	//remove  first object from tree
	public void remove() {
		aircrafts.pollFirst();
		
	}
	

}
