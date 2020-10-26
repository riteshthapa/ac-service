package com.aircraft.acservice.processor;

import com.aircraft.acservice.model.Aircraft;

public class EnqueRequest implements Request {

	private Aircraft aircraft;
	
	  public  EnqueRequest(Aircraft crafts) {
		  this.aircraft = crafts;

	   }
	  
	  public Aircraft getAircraft() {
		  return aircraft;
	  }
}
