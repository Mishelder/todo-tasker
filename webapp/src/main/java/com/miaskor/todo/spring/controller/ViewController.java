package com.miaskor.todo.spring.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  private final HttpSession httpSession;

  @Autowired
  public ViewController(HttpSession httpSession) {
    this.httpSession = httpSession;
  }

  @GetMapping("/todo")
  public String getToDo() {
    return "todo";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }

  @GetMapping("/inbox")
  public String getInbox() {
    return "inbox";
  }

  @GetMapping("/logout")
  public String loggedOut() {
    httpSession.invalidate();
    return "authorization";
  }

  @GetMapping("/auth")
  public String getLoginPage() {
    return "authorization";
  }
}
