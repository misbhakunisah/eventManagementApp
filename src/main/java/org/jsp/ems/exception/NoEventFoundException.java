package org.jsp.ems.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoEventFoundException extends RuntimeException{
 
private String message;
	
	NoEventFoundException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
