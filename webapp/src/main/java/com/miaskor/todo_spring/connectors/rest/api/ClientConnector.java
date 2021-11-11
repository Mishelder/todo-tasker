package com.miaskor.todo_spring.connectors.rest.api;

import by.miaskor.domain.rest.api.ClientRequestDto;
import by.miaskor.domain.rest.api.ClientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rest-api-client", url = "${connector.rest-api.url}")
public interface ClientConnector {

  @RequestMapping(value = "/clients/auth", method = RequestMethod.GET)
  ClientResponseDto getClientByLoginAndPassword(@RequestParam String login, @RequestParam String password);

  @RequestMapping(value = "/clients", method = RequestMethod.POST)
  ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto);
}
