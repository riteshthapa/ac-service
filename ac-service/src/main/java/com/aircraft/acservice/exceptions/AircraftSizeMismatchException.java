package com.aircraft.acservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "size should be either large or small")
public class AircraftSizeMismatchException extends RuntimeException {

}
