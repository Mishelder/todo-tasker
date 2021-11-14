package com.miaskor.todo.spring.exception;

public class ClientException extends RuntimeException {

    public ClientException(String message) {
        super(message);
    }
}
