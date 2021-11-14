package com.miaskor.todo.spring.controller;

import by.miaskor.rest.connector.ClientConnector;
import by.miaskor.rest.dto.ClientDtoRequest;
import by.miaskor.rest.dto.ClientDtoResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthorizationController {

  private final HttpSession httpSession;
  private final ClientConnector clientConnector;

  @Autowired
  public AuthorizationController(HttpSession httpSession,
      ClientConnector clientConnector) {
    this.httpSession = httpSession;
    this.clientConnector = clientConnector;
  }

  @PostMapping("/auth")
  @Transactional(readOnly = true)
  public ResponseEntity<ClientDtoResponse> loginClient(@RequestBody ClientDtoRequest clientDtoRequest) {
    ClientDtoResponse clientByLoginAndPassword = clientConnector.getClientByLoginAndPassword(
        clientDtoRequest.getLogin(),
        clientDtoRequest.getPassword());
    httpSession.setAttribute("client", clientByLoginAndPassword);
    return ResponseEntity.ok(clientByLoginAndPassword);
  }

  @PostMapping("/registration")
  @Transactional()
  public ResponseEntity<ClientDtoResponse> registrationClient(@RequestBody ClientDtoRequest clientRequestDto) {
    ClientDtoResponse client = clientConnector.createClient(clientRequestDto);
    httpSession.setAttribute("client", client);
    return ResponseEntity.ok(client);
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
