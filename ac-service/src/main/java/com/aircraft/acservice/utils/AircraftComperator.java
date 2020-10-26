package com.aircraft.acservice.utils;

import java.util.Comparator;

import com.aircraft.acservice.model.Aircraft;

public class AircraftComperator implements Comparator<Aircraft> {

	@Override
	public int compare(Aircraft craft1, Aircraft craft2) {
		if (craft1.getPriority() >= craft2.getPriority()) {
			return 1;
		} else {
			return -1;
		}
	}

}
