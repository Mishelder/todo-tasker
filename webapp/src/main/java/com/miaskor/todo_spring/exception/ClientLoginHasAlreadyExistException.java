package com.miaskor.todo_spring.exception;

public class ClientLoginHasAlreadyExistException extends ClientException {

  public ClientLoginHasAlreadyExistException(String message) {
    super(message);
  }
}
