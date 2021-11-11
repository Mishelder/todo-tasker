package com.miaskor.todo_spring.exception;

public class ClientIsNotExistException extends ClientException {

    public ClientIsNotExistException(String message) {
        super(message);
    }
}
