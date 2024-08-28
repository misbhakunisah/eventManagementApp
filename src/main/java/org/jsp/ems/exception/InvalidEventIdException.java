package org.jsp.ems.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class InvalidEventIdException extends RuntimeException{
	 
	private String message;
		
	InvalidEventIdException(String message){
			this.message=message;
		}
		
		@Override
		public String getMessage() {
			return this.message;
		}
		
}
