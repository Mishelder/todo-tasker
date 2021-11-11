package com.miaskor.todo_spring.exception;

public class TaskIsNotExistException extends TaskException {

    public TaskIsNotExistException(String message) {
        super(message);
    }
}
