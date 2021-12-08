package com.miaskor.todo.spring.controller;

import by.miaskor.domain.connector.ClientConnector;
import by.miaskor.domain.dto.ClientDtoRequest;
import by.miaskor.token.connector.connector.TokenConnector;
import by.miaskor.token.connector.domain.ClientAuthDtoRequest;
import java.net.URI;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthorizationController {

  private final HttpServletResponse httpServletResponse;
  private final HttpSession httpSession;
  private final ClientConnector clientConnector;
  private final TokenConnector tokenConnector;

  @Autowired
  public AuthorizationController(HttpServletResponse httpServletResponse, HttpSession httpSession,
      ClientConnector clientConnector, TokenConnector tokenConnector) {
    this.httpServletResponse = httpServletResponse;
    this.httpSession = httpSession;
    this.clientConnector = clientConnector;
    this.tokenConnector = tokenConnector;
  }

  @PostMapping("/auth")
  public ResponseEntity<Object> loginClient(@RequestBody ClientDtoRequest clientDtoRequest) {
    Map<String, String> token = tokenConnector.createToken(
        new ClientAuthDtoRequest(clientDtoRequest.getLogin(), clientDtoRequest.getPassword())
    );
    Cookie clientId = new Cookie("clientId", token.get("clientId"));
    Cookie accessToken = new Cookie("token", token.get("token"));
    httpServletResponse.addCookie(clientId);
    httpServletResponse.addCookie(accessToken);
    httpSession.setAttribute("clientId", token.get("clientId"));
    httpSession.setAttribute("token", token.get("token"));
    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create("/todo")).build();
  }

  @PostMapping("/registration")
  public ResponseEntity<Object> registrationClient(@RequestBody ClientDtoRequest clientRequestDto) {
    clientConnector.createClient(clientRequestDto);
    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create("/auth")).build();
  }
}
