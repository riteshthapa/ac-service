package com.aircraft.acservice.controller;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aircraft.acservice.exceptions.AircraftSizeMismatchException;
import com.aircraft.acservice.exceptions.AircraftTypeMismatchException;
import com.aircraft.acservice.model.Aircraft;
import com.aircraft.acservice.processor.DequeueRequest;
import com.aircraft.acservice.processor.EnqueRequest;
import com.aircraft.acservice.processor.QueueManager;
import com.aircraft.acservice.utils.Priority;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AircraftController {
	
	@Autowired
	private QueueManager processor;
	
	@GetMapping(value="/service/crafts")
	public TreeSet<Aircraft> getCrafts() {
		return processor.getCrafts();
	}
	
	
	@PostMapping(value="/service/crafts")
	@ExceptionHandler({AircraftTypeMismatchException.class,AircraftSizeMismatchException.class}) 
	public void addAircraft(@RequestBody Aircraft craft) {
		if (!(craft.getType().equalsIgnoreCase("cargo") || craft.getType().equalsIgnoreCase("passenger"))) {
			throw new AircraftTypeMismatchException();
		}
		if (!(craft.getSize().equalsIgnoreCase("large") || craft.getSize().equalsIgnoreCase("small"))) {
			throw new AircraftSizeMismatchException();
		}
		
		int priority = Priority.caluclatePriority(craft);
		//set priority
		craft.setPriority(priority);
		
		String uniqueID = UUID.randomUUID().toString();
		
		if (craft.getType().equals("cargo") || (craft.getType().equals("Cargo"))) {
			String id = "CARGO"+uniqueID;
			craft.setId(id);
		}else {
			String id = "PASS"+uniqueID;
			craft.setId(id);
		}
		
		craft.setDoe(new SimpleDateFormat("EEE, MM/dd/yyyy 'at' h:mm a z").format(new Date()));
		processor.aqmRequestProcess(new EnqueRequest(craft));
			
	}
	
	@DeleteMapping(value = "/service/crafts")
	public void remove() {
			processor.aqmRequestProcess(new DequeueRequest() );		
		}		

}
