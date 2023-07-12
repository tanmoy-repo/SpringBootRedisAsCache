package com.gitgenius;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   
	
	private static final long serialVersionUID = 7607701755886102443L;

	public ResourceNotFoundException(String message) {
	super(message);
}
}
