package com.miaskor.todo.spring.exception;

public class ClientEmailHasAlreadyExistException extends ClientException {

    public ClientEmailHasAlreadyExistException(String message) {
        super(message);
    }
}
