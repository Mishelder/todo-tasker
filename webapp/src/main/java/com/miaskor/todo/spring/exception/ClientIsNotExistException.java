package com.miaskor.todo.spring.exception;

public class ClientIsNotExistException extends ClientException {

    public ClientIsNotExistException(String message) {
        super(message);
    }
}
