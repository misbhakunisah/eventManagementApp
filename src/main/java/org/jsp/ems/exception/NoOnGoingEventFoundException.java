package org.jsp.ems.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoOnGoingEventFoundException extends RuntimeException{
	private String message;
	NoOnGoingEventFoundException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	

}
