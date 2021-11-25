package com.miaskor.todo.spring.controller;

import by.miaskor.domain.connector.ClientConnector;
import by.miaskor.domain.dto.ClientDtoRequest;
import by.miaskor.domain.dto.ClientDtoResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
  public ResponseEntity<ClientDtoResponse> loginClient(@RequestBody ClientDtoRequest clientDtoRequest) {
    ClientDtoResponse clientByLoginAndPassword = clientConnector.getClientByLoginAndPassword(
        clientDtoRequest.getLogin(),
        clientDtoRequest.getPassword());
    httpSession.setAttribute("client", clientByLoginAndPassword);
    return ResponseEntity.ok(clientByLoginAndPassword);
  }

  @PostMapping("/registration")
  public ResponseEntity<ClientDtoResponse> registrationClient(@RequestBody ClientDtoRequest clientRequestDto) {
    ClientDtoResponse client = clientConnector.createClient(clientRequestDto);
    return ResponseEntity.ok(client);
  }
}
