package com.miaskor.todo_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @GetMapping("/todo")
  public String getToDo() {
    return "todo";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }
}
