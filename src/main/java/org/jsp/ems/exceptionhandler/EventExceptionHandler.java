package org.jsp.ems.exceptionhandler;

import org.jsp.ems.exception.InvalidEventIdException;
import org.jsp.ems.exception.NoCompletedEventFoundException;
import org.jsp.ems.exception.NoEventFoundException;
import org.jsp.ems.exception.NoOnGoingEventFoundException;
import org.jsp.ems.exception.NoUpComingEventFoundException;
import org.jsp.ems.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class EventExceptionHandler {
	@ExceptionHandler(NoEventFoundException.class)
	public ResponseEntity<?> handleNoEventFoundException(NoEventFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("No Event Present in database").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoOnGoingEventFoundException.class)
	public ResponseEntity<?> handleNoOnGoingEventFoundException(NoOnGoingEventFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("No OnGoing Event Present in database").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidEventIdException.class)
	public ResponseEntity<?> handleInvalidEventIdException(InvalidEventIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("Invalid Event Id").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoUpComingEventFoundException.class)
	public ResponseEntity<?> handleNoUpComingEventFoundException(NoUpComingEventFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("No UpComing Event Present in database").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoCompletedEventFoundException.class)
	public ResponseEntity<?> handleNoCompletedEventFoundException(NoCompletedEventFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("No Completed Event Present in database").body(e.getMessage()).build());
	}
	
}
