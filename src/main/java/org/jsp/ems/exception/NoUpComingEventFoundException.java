package org.jsp.ems.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoUpComingEventFoundException extends RuntimeException{
	private String message;
	NoUpComingEventFoundException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
