package com.Speakingclock.Speaking.clock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Speakingclock.Speaking.clock.util.SpeakingClockConstants;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> numberFormattingExceptionHandler(Exception ex) {
		
		return new ResponseEntity<Object>(SpeakingClockConstants.ERROR_MESSAGE, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex) {
		
		return new ResponseEntity<Object>(SpeakingClockConstants.GENERIC_ERROR_MESSAGE, HttpStatus.NOT_FOUND);	
	}
	
	
	/*@ControllerAdvice
	public class ProductExceptionController {
	   @ExceptionHandler(value = ProductNotfoundException.class)
	   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	   }
	}*/

}
