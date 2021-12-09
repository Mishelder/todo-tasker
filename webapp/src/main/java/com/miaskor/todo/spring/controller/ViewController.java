package com.miaskor.todo.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  private final HttpSession httpSession;
  private final HttpServletResponse httpServletResponse;

  @Autowired
  public ViewController(HttpSession httpSession, HttpServletResponse httpServletResponse) {
    this.httpSession = httpSession;
    this.httpServletResponse = httpServletResponse;
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
    Cookie clientId = new Cookie("clientId", null);
    Cookie accessToken = new Cookie("token", null);
    clientId.setMaxAge(0);
    accessToken.setMaxAge(0);
    httpServletResponse.addCookie(clientId);
    httpServletResponse.addCookie(accessToken);
    httpSession.invalidate();
    return "authorization";
  }

  @GetMapping("/auth")
  public String getLoginPage() {
    return "authorization";
  }
}
