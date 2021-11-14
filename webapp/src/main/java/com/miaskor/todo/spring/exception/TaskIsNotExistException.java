package com.miaskor.todo.spring.exception;

public class TaskIsNotExistException extends TaskException {

    public TaskIsNotExistException(String message) {
        super(message);
    }
}
