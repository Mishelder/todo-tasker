package com.miaskor.todo_spring.exception;

public class ClientEmailHasAlreadyExistException extends ClientException {

    public ClientEmailHasAlreadyExistException(String message) {
        super(message);
    }
}
