package com.miaskor.todo_spring.controller;

import by.miaskor.domain.rest.api.ClientRequestDto;
import by.miaskor.domain.rest.api.ClientResponseDto;
import com.miaskor.todo_spring.connectors.rest.api.ClientConnector;
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
  public ResponseEntity<ClientResponseDto> loginClient(@RequestBody ClientRequestDto clientRequestDto) {
    ClientResponseDto clientByLoginAndPassword = clientConnector.getClientByLoginAndPassword(
        clientRequestDto.getLogin(),
        clientRequestDto.getPassword());
    httpSession.setAttribute("client", clientByLoginAndPassword);
    return ResponseEntity.ok(clientByLoginAndPassword);
  }

  @PostMapping("/registration")
  @Transactional()
  public ResponseEntity<ClientResponseDto> registrationClient(@RequestBody ClientRequestDto clientRequestDto) {
    ClientResponseDto client = clientConnector.createClient(clientRequestDto);
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
