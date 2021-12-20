package kea.exam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

  private ErrorMessage createErrorMessage(HttpStatus httpStatus, Exception exception, WebRequest webRequest) {
    return new ErrorMessage(httpStatus.value(),
        new Date(),
        exception.getMessage(),
        webRequest.getDescription(false));
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
    var httpStatus = HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(createErrorMessage(httpStatus, exception, webRequest), httpStatus);
  }

  @ExceptionHandler(ResourceNotCreatedException.class)
  public ResponseEntity<ErrorMessage> resourceNotCreatedException(ResourceNotCreatedException exception, WebRequest webRequest) {
    var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<>(createErrorMessage(httpStatus, exception, webRequest), httpStatus);
  }

  // default exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception exception, WebRequest webRequest) {
    var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<>(createErrorMessage(httpStatus, exception, webRequest), httpStatus);
  }

}
