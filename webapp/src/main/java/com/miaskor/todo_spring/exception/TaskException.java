package com.miaskor.todo_spring.exception;

public class TaskException extends RuntimeException {

    public TaskException(String message) {
        super(message);
    }
}
