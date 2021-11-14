package com.miaskor.todo.spring.handler;

import com.miaskor.todo.spring.exception.ClientException;
import com.miaskor.todo.spring.exception.TaskException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

  @ExceptionHandler()
  public ResponseEntity<IncorrectData> clientException(ClientException exception) {
    IncorrectData incorrectData = new IncorrectData();
    incorrectData.setMessage(exception.getMessage());
    return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler()
  public ResponseEntity<IncorrectData> taskException(TaskException exception) {
    IncorrectData incorrectData = new IncorrectData();
    incorrectData.setMessage(exception.getMessage());
    return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
  }
}
