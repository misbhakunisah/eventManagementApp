package org.jsp.ems.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoCompletedEventFoundException extends RuntimeException{

	private String message;
	NoCompletedEventFoundException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
