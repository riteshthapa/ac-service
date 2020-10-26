package com.aircraft.acservice.utils;

import com.aircraft.acservice.model.Aircraft;

public class Priority {
	
	public static int caluclatePriority(Aircraft craft) {
		int priority = 0;
		switch (craft.getType().toLowerCase()) {
		case "passenger":
			if (craft.getSize().equalsIgnoreCase("large")) {
				priority = 1;
			} else {
				priority = 2;
			}
			break;
		case "cargo":
			if (craft.getSize().equalsIgnoreCase("large")) {
				priority = 3;

			} else {
				priority = 4;
			}
		}

		return priority;
	}

}
