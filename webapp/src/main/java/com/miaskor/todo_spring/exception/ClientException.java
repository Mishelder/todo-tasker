package com.miaskor.todo_spring.exception;

public class ClientException extends RuntimeException {

    public ClientException(String message) {
        super(message);
    }
}
