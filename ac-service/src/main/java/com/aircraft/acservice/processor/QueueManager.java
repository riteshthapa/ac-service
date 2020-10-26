package com.aircraft.acservice.processor;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircraft.acservice.model.Aircraft;
import com.aircraft.acservice.service.AircraftService;

@Service
public class QueueManager {
	@Autowired
	private AircraftService aircraftService;	
		
	public void aqmRequestProcess(Request request) {
		   if (request instanceof EnqueRequest) {
			   aircraftService.add(request.getAircraft());
		   } else if (request instanceof DequeueRequest) {
			   aircraftService.remove();
		   } 
		}
	
	//added this method to list elements in the queue/
	
	public TreeSet<Aircraft> getCrafts() {
		return aircraftService.getAllAircrafts();
	}


}
