package fr.insee.sabianedata.ws.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		exception.printStackTrace();
		return new ResponseEntity<>("Unknown error during generation : "+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}