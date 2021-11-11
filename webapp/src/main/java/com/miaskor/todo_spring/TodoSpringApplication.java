package com.miaskor.todo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TodoSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoSpringApplication.class, args);
  }
}
