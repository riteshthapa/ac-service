package com.aircraft.acservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason ="type should be either passenger or craft")
public class AircraftTypeMismatchException extends RuntimeException {

	private static final long serialVersionUID = -4388755182110727363L;
}
