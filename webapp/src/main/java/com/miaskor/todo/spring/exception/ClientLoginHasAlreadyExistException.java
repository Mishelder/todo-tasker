package com.miaskor.todo.spring.exception;

public class ClientLoginHasAlreadyExistException extends ClientException {

  public ClientLoginHasAlreadyExistException(String message) {
    super(message);
  }
}
